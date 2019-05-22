package xyz.gabrielrohez.themoviedb.ui.splash.splashinterface;

public interface SplashInterface {

    interface Model {

        void getMovies(View listener);
    }

    interface View {

    }

    interface Presenter {
        void getMovies();
    }
}
