package xyz.gabrielrohez.themoviedb.ui.popular.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.popular.presenter.PopularPresenterListener;

public interface PopularModelIn {
    void getPopularMovies(PopularPresenterListener listener, BasicUIListener uiListener);
}
