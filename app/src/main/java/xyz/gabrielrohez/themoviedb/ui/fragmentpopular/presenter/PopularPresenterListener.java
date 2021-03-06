package xyz.gabrielrohez.themoviedb.ui.fragmentpopular.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface PopularPresenterListener {
    void showRefreshLayout(boolean bool);
    void setNewPopularMovies(List<MoviesEntity> movies);
}
