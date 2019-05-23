package xyz.gabrielrohez.themoviedb.ui.top.view;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface TopView {
    void setNewTopMovies(List<MoviesEntity> movies);
    void showRefreshLayout(boolean bool);
}
