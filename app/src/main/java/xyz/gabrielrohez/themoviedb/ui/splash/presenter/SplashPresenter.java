package xyz.gabrielrohez.themoviedb.ui.splash.presenter;

import xyz.gabrielrohez.themoviedb.ui.splash.model.SplashModel;
import xyz.gabrielrohez.themoviedb.ui.splash.splashinterface.SplashInterface;

public class SplashPresenter implements SplashInterface.Presenter {

    private SplashModel model;
    private SplashInterface.View view;

    public SplashPresenter(SplashInterface.View view) {
        this.view = view;
        model = new SplashModel();
    }

    @Override
    public void getMovies() {
        model.getMovies(view);
    }
}
