package xyz.gabrielrohez.themoviedb.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;

public interface ApiEndpoint {

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey);
}
