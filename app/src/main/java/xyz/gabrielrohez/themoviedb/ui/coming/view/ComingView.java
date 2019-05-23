package xyz.gabrielrohez.themoviedb.ui.coming.view;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface ComingView {
    void showRefreshLayout(boolean bool);
    void setNewComingMovies(List<MoviesEntity> movies);
}
