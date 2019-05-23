package xyz.gabrielrohez.themoviedb.base.presenter;

public interface BasicUIListener {
    void showDialog(String message, int value);
    void showLoader(boolean visible);
}
