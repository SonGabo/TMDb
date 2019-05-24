package xyz.gabrielrohez.themoviedb.ui.fragmenttop.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.fragmenttop.presenter.TopPresenterListener;

public interface TopModelIn {
    void getTopMovies(TopPresenterListener listener, BasicUIListener uiListener);
}
