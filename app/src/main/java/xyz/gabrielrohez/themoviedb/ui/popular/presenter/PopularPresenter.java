package xyz.gabrielrohez.themoviedb.ui.popular.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.base.activity.BasicUIView;
import xyz.gabrielrohez.themoviedb.base.presenter.BasicUIPresenter;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.popular.model.PopularModel;
import xyz.gabrielrohez.themoviedb.ui.popular.model.PopularModelIn;
import xyz.gabrielrohez.themoviedb.ui.popular.view.PopularView;

public class PopularPresenter extends BasicUIPresenter implements PopularPresenterIn, PopularPresenterListener {

    private PopularView view;
    private PopularModelIn model;

    public PopularPresenter(BasicUIView basicUIView, PopularView view) {
        super(basicUIView);
        this.view = view;
        model = new PopularModel();
    }

    @Override
    public void getPopularMovies() {
        model.getPopularMovies(this, this);
    }


    @Override
    public void showRefreshLayout(boolean bool) {
        if (view != null){
            view.showRefreshLayout(bool);
        }
    }

    @Override
    public void setNewPopularMovies(List<MoviesEntity> movies) {
        if (view != null){
            view.setNewPopularMovies(movies);
        }
    }
}
