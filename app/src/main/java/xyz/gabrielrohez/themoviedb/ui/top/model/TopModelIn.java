package xyz.gabrielrohez.themoviedb.ui.top.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.top.presenter.TopPresenterListener;

public interface TopModelIn {
    void getTopMovies(TopPresenterListener listener, BasicUIListener uiListener);
}
