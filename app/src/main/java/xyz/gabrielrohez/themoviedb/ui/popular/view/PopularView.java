package xyz.gabrielrohez.themoviedb.ui.popular.view;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface PopularView {
    void showRefreshLayout(boolean bool);
    void setNewPopularMovies(List<MoviesEntity> movies);
}
