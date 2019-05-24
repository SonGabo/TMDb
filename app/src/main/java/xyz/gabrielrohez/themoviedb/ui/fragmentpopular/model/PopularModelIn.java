package xyz.gabrielrohez.themoviedb.ui.fragmentpopular.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.fragmentpopular.presenter.PopularPresenterListener;

public interface PopularModelIn {
    void getPopularMovies(PopularPresenterListener listener, BasicUIListener uiListener);
}
