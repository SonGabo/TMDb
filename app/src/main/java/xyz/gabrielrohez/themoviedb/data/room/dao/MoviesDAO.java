package xyz.gabrielrohez.themoviedb.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

@Dao
public interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MoviesEntity movies);

    @Delete
    void delete(MoviesEntity movies);

    @Query("DELETE FROM movies")
    void deleteAll();

    @Query("DELETE FROM movies WHERE type=:type")
    void deleteCategory(String type);

    @Query("SELECT * FROM movies")
    List<MoviesEntity> getAllMovies();

    @Query("SELECT * FROM movies WHERE type=:type")
    List<MoviesEntity> getCategory(String type);

    @Query("SELECT * FROM movies WHERE id_movie=:id_movie")
    MoviesEntity getMovie(String id_movie);

    @Query("SELECT count(*) FROM movies")
    Cursor cursor();
}
