package xyz.gabrielrohez.themoviedb.ui.top.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface TopPresenterListener {
    void setNewTopMovies(List<MoviesEntity> movies);
    void showRefreshLayout(boolean bool);
}
