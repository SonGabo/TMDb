package xyz.gabrielrohez.themoviedb.ui.top.presenter;

import xyz.gabrielrohez.themoviedb.ui.top.model.TopModel;
import xyz.gabrielrohez.themoviedb.ui.top.model.TopModelIn;
import xyz.gabrielrohez.themoviedb.ui.top.view.TopView;

public class TopPresenter implements TopPresenterIn, TopPresenterListener {

    private TopView view;
    private TopModelIn model;

    public TopPresenter(TopView view) {
        this.view = view;
        model = new TopModel();
    }
}
