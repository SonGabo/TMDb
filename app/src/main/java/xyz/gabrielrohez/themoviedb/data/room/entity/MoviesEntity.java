package xyz.gabrielrohez.themoviedb.data.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import xyz.gabrielrohez.themoviedb.utils.AppConstants;

@Entity(tableName = AppConstants.movies)
public class MoviesEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "id_movie")
    private int id_movie;
    @ColumnInfo(name = "video")
    private boolean video;
    @ColumnInfo(name = "vote_average")
    private String vote_average;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "poster_path")
    private String poster_path;
    @ColumnInfo(name = "original_language")
    private String original_language;
    @ColumnInfo(name = "original_title")
    private String original_title;
    @ColumnInfo(name = "backdrop_path")
    private String backdrop_path;
    @ColumnInfo(name = "adult")
    private boolean adult;
    @ColumnInfo(name = "overview")
    private String overview;
    @ColumnInfo(name = "release_date")
    private String release_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "id=" + id +
                ", type=" + type +
                ", id_movie=" + id_movie +
                ", video=" + video +
                ", vote_average='" + vote_average + '\'' +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
