package xyz.gabrielrohez.themoviedb.ui.main.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.main.model.MainModel;
import xyz.gabrielrohez.themoviedb.ui.main.model.MainModelIn;
import xyz.gabrielrohez.themoviedb.ui.main.view.MainView;

public class MainPresenter implements MainPresenterIn, MainPresenterListener {

    private MainView view;
    private MainModelIn model;

    public MainPresenter(MainView view) {
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void getPopularMovies() {
        model.getPopularMovies(this);
    }

    @Override
    public void setCategoryMovies(List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList) {
        if (view != null){
            view.setCategoryMovies(popularList, topList, comingList);
        }
    }
}
