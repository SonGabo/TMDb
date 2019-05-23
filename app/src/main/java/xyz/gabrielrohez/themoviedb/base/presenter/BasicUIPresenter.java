package xyz.gabrielrohez.themoviedb.base.presenter;

import xyz.gabrielrohez.themoviedb.base.activity.BasicUIView;

public class BasicUIPresenter implements BasicUIListener {

    private BasicUIView basicUIView;

    public BasicUIPresenter(BasicUIView basicUIView) {
        this.basicUIView = basicUIView;
    }

    @Override
    public void showDialog(String message, int value) {
        if (basicUIView != null){
            basicUIView.showDialog(message, value);
        }
    }

    @Override
    public void showLoader(boolean visible) {
        if (basicUIView != null){
            basicUIView.showLoader(visible);
        }
    }
}
