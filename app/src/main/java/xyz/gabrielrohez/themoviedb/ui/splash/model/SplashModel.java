package xyz.gabrielrohez.themoviedb.ui.splash.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.themoviedb.data.network.ApiEndpoint;
import xyz.gabrielrohez.themoviedb.data.network.RetrofitClient;
import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;
import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenterListener;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;
import xyz.gabrielrohez.themoviedb.utils.Utils;

public class SplashModel implements SplashModelIn {

    @Override
    public void getMovies(final SplashPresenterListener listener) {

        if (Utils.isOnline(AppConfig.getAppContext())){
            RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getPopularMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    if (response.isSuccessful()){
                        if (response.body()!=null){

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
        }else {
            listener.showMessageError(AppConfig.androidResourceManager.getMessageWithoutInternetConnection());
        }
    }
}
