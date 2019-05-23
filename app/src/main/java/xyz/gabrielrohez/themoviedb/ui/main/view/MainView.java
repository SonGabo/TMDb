package xyz.gabrielrohez.themoviedb.ui.main.view;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface MainView {
    void setCategoryMovies(List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList);
}
