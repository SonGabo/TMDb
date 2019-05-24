package xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter;

import xyz.gabrielrohez.themoviedb.ui.moviedetail.model.DetailModel;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.model.DetailModelIn;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.view.DetailView;

public class DetailPresenter implements DetailPresenterIn, DetailPresenterListener {

    private DetailView view;
    private DetailModelIn model;

    public DetailPresenter(DetailView view) {
        this.view = view;
        model = new DetailModel();
    }

    @Override
    public void getKeyFromVideo(int id_movie) {
        model.getKeyFromVideo(this, String.valueOf(id_movie));
    }

    @Override
    public void loadVideo(String url) {
        if (view != null){
            view.loadVideo(url);
        }
    }

    @Override
    public void videoNotAailable(String message) {
        if (view != null){
            view.videoNotAailable(message);
        }
    }
}
