package xyz.gabrielrohez.themoviedb.ui.moviedetail.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.themoviedb.data.network.ApiEndpoint;
import xyz.gabrielrohez.themoviedb.data.network.RetrofitClient;
import xyz.gabrielrohez.themoviedb.data.network.model.VideoResponse;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter.DetailPresenterListener;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;
import xyz.gabrielrohez.themoviedb.utils.Utils;

public class DetailModel implements DetailModelIn {

    @Override
    public void getKeyFromVideo(final DetailPresenterListener listener, String id) {
        if (Utils.isOnline(AppConfig.getAppContext())){
            RetrofitClient.getInstance().retrofitVideo.create(ApiEndpoint.class).getKeyFromVideo(id, AppConstants.API_KEY).enqueue(new Callback<VideoResponse>() {
                @Override
                public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                    if (response.isSuccessful()){
                        if (response.body() != null){
                            listener.loadVideo(response.body().getResults().get(0).getKey());
                        }else
                            listener.videoNotAailable(AppConfig.androidResourceManager.getVideoNotAvaible());
                    }else
                        listener.videoNotAailable(AppConfig.androidResourceManager.getVideoNotAvaible());
                }

                @Override
                public void onFailure(Call<VideoResponse> call, Throwable t) {
                    listener.videoNotAailable(AppConfig.androidResourceManager.getVideoNotAvaible());
                }
            });
        }else {
            listener.videoNotAailable(AppConfig.androidResourceManager.getVideoNotAvaible());
        }
    }
}
