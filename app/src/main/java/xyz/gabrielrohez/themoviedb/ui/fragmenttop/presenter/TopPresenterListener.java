package xyz.gabrielrohez.themoviedb.ui.fragmenttop.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface TopPresenterListener {
    void setNewTopMovies(List<MoviesEntity> movies);
    void showRefreshLayout(boolean bool);
}
