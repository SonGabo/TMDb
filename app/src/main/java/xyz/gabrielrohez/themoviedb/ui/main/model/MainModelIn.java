package xyz.gabrielrohez.themoviedb.ui.main.model;

import xyz.gabrielrohez.themoviedb.ui.main.presenter.MainPresenterListener;

public interface MainModelIn {
    void getPopularMovies(MainPresenterListener listener);

}
