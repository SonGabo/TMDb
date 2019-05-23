package xyz.gabrielrohez.themoviedb.ui.coming.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.base.activity.BasicUIView;
import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIPresenter;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.coming.model.ComingModel;
import xyz.gabrielrohez.themoviedb.ui.coming.model.ComingModelIn;
import xyz.gabrielrohez.themoviedb.ui.coming.view.ComingView;

public class ComingPresenter extends BasicUIPresenter implements ComingPresenterIn, ComingPresenterListener {

    private ComingView view;
    private ComingModelIn model;

    public ComingPresenter(BasicUIView basicUIView, ComingView view) {
        super(basicUIView);
        this.view = view;
        model = new ComingModel();
    }

    @Override
    public void getComingMovies() {
        model.getComingMovies(this, this);
    }

    @Override
    public void showRefreshLayout(boolean bool) {
        if (view != null) {
            view.showRefreshLayout(bool);
        }
    }

    @Override
    public void setNewComingMovies(List<MoviesEntity> movies) {
        if (view != null) {
            view.setNewComingMovies(movies);
        }
    }
}
