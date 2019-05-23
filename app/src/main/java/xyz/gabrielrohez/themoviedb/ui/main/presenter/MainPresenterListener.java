package xyz.gabrielrohez.themoviedb.ui.main.presenter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

public interface MainPresenterListener {
    void setCategoryMovies(List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList);
}
