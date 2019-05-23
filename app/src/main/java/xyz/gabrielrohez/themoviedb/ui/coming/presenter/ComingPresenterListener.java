package xyz.gabrielrohez.themoviedb.ui.coming.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface ComingPresenterListener {
    void showRefreshLayout(boolean bool);
    void setNewComingMovies(List<MoviesEntity> movies);
}
