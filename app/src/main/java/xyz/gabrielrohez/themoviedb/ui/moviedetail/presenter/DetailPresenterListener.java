package xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter;

public interface DetailPresenterListener {
    void loadVideo(String url);
    void videoNotAailable(String message);
}
