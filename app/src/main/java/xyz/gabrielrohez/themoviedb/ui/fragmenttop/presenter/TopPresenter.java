package xyz.gabrielrohez.themoviedb.ui.fragmenttop.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.base.activity.BasicUIView;
import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIPresenter;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.fragmenttop.model.TopModel;
import xyz.gabrielrohez.themoviedb.ui.fragmenttop.model.TopModelIn;
import xyz.gabrielrohez.themoviedb.ui.fragmenttop.view.TopView;

public class TopPresenter extends BasicUIPresenter implements TopPresenterIn, TopPresenterListener {

    private TopView view;
    private TopModelIn model;

    public TopPresenter(BasicUIView basicUIView, TopView view) {
        super(basicUIView);
        this.view = view;
        model = new TopModel();
    }

    @Override
    public void getTopMovies() {
        model.getTopMovies(this, this);
    }

    @Override
    public void setNewTopMovies(List<MoviesEntity> movies) {
        if (view != null){
            view.setNewTopMovies(movies);
        }
    }

    @Override
    public void showRefreshLayout(boolean bool) {
        if (view != null){
            view.showRefreshLayout(bool);
        }
    }
}
