package xyz.gabrielrohez.themoviedb.ui.coming.model;

import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIListener;
import xyz.gabrielrohez.themoviedb.ui.coming.presenter.ComingPresenterListener;

public interface ComingModelIn {
    void getComingMovies(ComingPresenterListener listener, BasicUIListener uiListener);
}
