package xyz.gabrielrohez.themoviedb.ui.moviedetail.model;

import xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter.DetailPresenterListener;

public interface DetailModelIn {
    void getKeyFromVideo(DetailPresenterListener listener, String id);
}
