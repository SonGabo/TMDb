package xyz.gabrielrohez.themoviedb.ui.splash.model;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.themoviedb.data.network.ApiEndpoint;
import xyz.gabrielrohez.themoviedb.data.network.RetrofitClient;
import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;
import xyz.gabrielrohez.themoviedb.ui.splash.splashinterface.SplashInterface;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class SplashModel implements SplashInterface.Model {

    @Override
    public void getMovies(SplashInterface.View listener) {

        RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getPopularMovies(AppConstants.API_KEY).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }
}
