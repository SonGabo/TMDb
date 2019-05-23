package xyz.gabrielrohez.themoviedb.ui.main.model;

import java.util.ArrayList;
import java.util.List;

import xyz.gabrielrohez.themoviedb.data.async.AsyncMethods;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.main.presenter.MainPresenterListener;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;

public class MainModel implements MainModelIn {

    List<MoviesEntity> popularList = new ArrayList<>();
    List<MoviesEntity> topList = new ArrayList<>();
    List<MoviesEntity> comingList = new ArrayList<>();

    @Override
    public void getPopularMovies(final MainPresenterListener listener) {

        AsyncMethods.Category getPopular = new AsyncMethods.Category(new AsyncMethods.Category.CategoryIn() {
            @Override
            public void readSuccessfully(List<MoviesEntity> moviesList) {
                popularList.addAll(moviesList);
                getTopMovies(listener);
            }
        });
        getPopular.execute(AppConfig.androidResourceManager.getTypePopular());
    }

    private void getTopMovies(final MainPresenterListener listener) {
        AsyncMethods.Category getTop = new AsyncMethods.Category(new AsyncMethods.Category.CategoryIn() {
            @Override
            public void readSuccessfully(List<MoviesEntity> moviesList) {
                topList.addAll(moviesList);
                getComingMovies(listener);
            }
        });
        getTop.execute(AppConfig.androidResourceManager.getTopRated());
    }

    private void getComingMovies(final MainPresenterListener listener) {
        AsyncMethods.Category getComingMovies = new AsyncMethods.Category(new AsyncMethods.Category.CategoryIn() {
            @Override
            public void readSuccessfully(List<MoviesEntity> moviesList) {
                comingList.addAll(moviesList);
                listener.setCategoryMovies(popularList, topList, comingList);
            }
        });
        getComingMovies.execute(AppConfig.androidResourceManager.getUpcoming());
    }
}
