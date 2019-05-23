package xyz.gabrielrohez.themoviedb.ui.splash.presenter;

import xyz.gabrielrohez.themoviedb.ui.splash.model.SplashModel;
import xyz.gabrielrohez.themoviedb.ui.splash.view.SplashView;

public class SplashPresenter implements SplashPresenterIn, SplashPresenterListener {

    private SplashView view;
    private SplashModel model;

    public SplashPresenter(SplashView view) {
        this.view = view;
        model = new SplashModel();
    }

    @Override
    public void getMovies() {
        model.getMovies(this);
    }

    @Override
    public void showMessageError(String message) {
        if (view != null){
            view.showMessageError(message);
        }
    }

    @Override
    public void moviesStoredInDatabase() {
        if (view != null){
            view.moviesStoredInDatabase();
        }
    }
}
