package xyz.gabrielrohez.themoviedb.ui.splash.model;

import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenter;
import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenterListener;

public interface SplashModelIn {
    void getMovies(SplashPresenterListener listener);
}
