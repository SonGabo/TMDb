package xyz.gabrielrohez.themoviedb.ui.splash.presenter;

public interface SplashPresenterListener {
    void showMessageError(String message);
    void moviesStoredInDatabase();
}
