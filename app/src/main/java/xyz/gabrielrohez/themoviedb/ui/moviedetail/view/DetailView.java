package xyz.gabrielrohez.themoviedb.ui.moviedetail.view;

public interface DetailView {
    void loadVideo(String url);
    void videoNotAailable(String message);
}
