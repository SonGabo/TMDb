package xyz.gabrielrohez.themoviedb.ui.fragmenttop.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.data.async.AsyncMethods;
import xyz.gabrielrohez.themoviedb.data.network.ApiEndpoint;
import xyz.gabrielrohez.themoviedb.data.network.RetrofitClient;
import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.fragmenttop.presenter.TopPresenterListener;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;
import xyz.gabrielrohez.themoviedb.utils.Utils;

public class TopModel implements TopModelIn {

    @Override
    public void getTopMovies(final TopPresenterListener listener, final BasicUIListener uiListener) {
        try {
            if (Utils.isOnline(AppConfig.getAppContext())){
                RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getTopRatedMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body()!=null){
                                deleteOldMovies(response.body().getResults(), listener);
                            }else{
                                listener.showRefreshLayout(false);
                                uiListener.showDialog(AppConfig.androidResourceManager.getMessageNoDataAvailable(), 1);
                            }
                        }else {
                            listener.showRefreshLayout(false);
                            uiListener.showDialog(AppConfig.androidResourceManager.getMessageError(), 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        listener.showRefreshLayout(false);
                        uiListener.showDialog(AppConfig.androidResourceManager.getMessageRetrofitFailure(), 1);
                    }
                });
            }else{
                listener.showRefreshLayout(false);
                uiListener.showDialog(AppConfig.androidResourceManager.getMessageWithoutInternetConnection(), 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void deleteOldMovies(final List<MoviesResponse.Results> results, final TopPresenterListener listener) {

        AsyncMethods.DeleteCategory deleteCategory = new AsyncMethods.DeleteCategory(new AsyncMethods.DeleteCategory.DeleteCategoryIn() {
            @Override
            public void deleteSuccessfully() {
                AsyncMethods.InsertMovie insertMovie = new AsyncMethods.InsertMovie(AppConfig.androidResourceManager.getTopRated(), new AsyncMethods.InsertMovie.InserMovieIn() {
                    @Override
                    public void storedSuccessfully(List<MoviesEntity> moviesEntities) {
                        listener.showRefreshLayout(false);
                        listener.setNewTopMovies(moviesEntities);
                    }
                });
                insertMovie.execute(results);
            }
        });
        deleteCategory.execute(AppConfig.androidResourceManager.getTopRated());
    }
}
