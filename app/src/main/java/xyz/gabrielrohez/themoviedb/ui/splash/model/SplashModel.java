package xyz.gabrielrohez.themoviedb.ui.splash.model;

import android.database.Cursor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.themoviedb.data.async.AsyncMethods;
import xyz.gabrielrohez.themoviedb.data.network.ApiEndpoint;
import xyz.gabrielrohez.themoviedb.data.network.RetrofitClient;
import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;
import xyz.gabrielrohez.themoviedb.data.room.db.AppDB;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenterListener;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;
import xyz.gabrielrohez.themoviedb.utils.Utils;

public class SplashModel implements SplashModelIn {

    /**
     * consumes the web service that returns the most popular movies and stores them in the database
     */
    @Override
    public void getMovies(final SplashPresenterListener listener) {

        Cursor cursor = AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().cursor();
        cursor.moveToFirst();
        int icount = cursor.getInt(0);

        if (icount>0){
            listener.moviesStoredInDatabase();
        } else {
            try {
                if (Utils.isOnline(AppConfig.getAppContext())){
                    RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getPopularMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
                        @Override
                        public void onResponse(Call<MoviesResponse> call, final Response<MoviesResponse> response) {
                            if (response.isSuccessful()){
                                if (response.body()!=null){
                                    AsyncMethods.InsertMovie insertMovie = new AsyncMethods.InsertMovie(AppConfig.androidResourceManager.getTypePopular(), new AsyncMethods.InsertMovie.InserMovieIn() {
                                        @Override
                                        public void storedSuccessfully(List<MoviesEntity> moviesEntities) {
                                            getTopRated(listener);
                                        }
                                    });
                                    insertMovie.execute(response.body().getResults());
                                }else
                                    listener.showMessageError(AppConfig.androidResourceManager.getMessageNoDataAvailable());
                            }else
                                listener.showMessageError(AppConfig.androidResourceManager.getMessageError());
                        }

                        @Override
                        public void onFailure(Call<MoviesResponse> call, Throwable t) {
                            listener.showMessageError(AppConfig.androidResourceManager.getMessageRetrofitFailure());
                        }
                    });
                }else
                    listener.showMessageError(AppConfig.androidResourceManager.getMessageWithoutInternetConnection());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * consumes the web service that returns the most rated movies and stores them in the database
     */
    private void getTopRated(final SplashPresenterListener listener) {
        try {
            if (Utils.isOnline(AppConfig.getAppContext())){
                RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getTopRatedMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body()!=null){
                                AsyncMethods.InsertMovie insertMovie = new AsyncMethods.InsertMovie(AppConfig.androidResourceManager.getTopRated(), new AsyncMethods.InsertMovie.InserMovieIn() {
                                    @Override
                                    public void storedSuccessfully(List<MoviesEntity> moviesEntities) {
                                        getUpcoming(listener);
                                    }
                                });
                                insertMovie.execute(response.body().getResults());
                            }else{
                                deleteData();
                                listener.showMessageError(AppConfig.androidResourceManager.getMessageNoDataAvailable());
                            }
                        }else {
                            deleteData();
                            listener.showMessageError(AppConfig.androidResourceManager.getMessageError());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        deleteData();
                        listener.showMessageError(AppConfig.androidResourceManager.getMessageRetrofitFailure());
                    }
                });
            }else{
                deleteData();
                listener.showMessageError(AppConfig.androidResourceManager.getMessageWithoutInternetConnection());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * consumes the web service that returns the next releases and stores them in the database
     */
    private void getUpcoming(final SplashPresenterListener listener) {
        try {
            if (Utils.isOnline(AppConfig.getAppContext())){
                RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getUpcomingMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body()!=null){
                                AsyncMethods.InsertMovie insertMovie = new AsyncMethods.InsertMovie(AppConfig.androidResourceManager.getUpcoming(), new AsyncMethods.InsertMovie.InserMovieIn() {
                                    @Override
                                    public void storedSuccessfully(List<MoviesEntity> moviesEntities) {
                                        listener.moviesStoredInDatabase();
                                    }
                                });
                                insertMovie.execute(response.body().getResults());
                            }else{
                                deleteData();
                                listener.showMessageError(AppConfig.androidResourceManager.getMessageNoDataAvailable());
                            }
                        }else {
                            deleteData();
                            listener.showMessageError(AppConfig.androidResourceManager.getMessageError());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        deleteData();
                        listener.showMessageError(AppConfig.androidResourceManager.getMessageRetrofitFailure());
                    }
                });
            }else {
                deleteData();
                listener.showMessageError(AppConfig.androidResourceManager.getMessageWithoutInternetConnection());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * delete all data in data base
     */
    public void deleteData() {
        AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().deleteAll();
    }

}
