package xyz.gabrielrohez.themoviedb.ui.fragmentcoming.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.fragmentcoming.presenter.ComingPresenterListener;

public interface ComingModelIn {
    void getComingMovies(ComingPresenterListener listener, BasicUIListener uiListener);
}
