package xyz.gabrielrohez.themoviedb.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("total_results")
    @Expose
    private int total_results;
    @SerializedName("total_pages")
    @Expose
    private int total_pages;
    @SerializedName("results")
    @Expose
    private List<Results> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
        @SerializedName("vote_count")
        @Expose
        private int vote_count;
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("video")
        @Expose
        private boolean video;
        @SerializedName("vote_average")
        @Expose
        private double vote_average;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("popularity")
        @Expose
        private double popularity;
        @SerializedName("poster_path")
        @Expose
        private String poster_path;
        @SerializedName("original_language")
        @Expose
        private String original_language;
        @SerializedName("original_title")
        @Expose
        private String original_title;
        @SerializedName("backdrop_path")
        @Expose
        private String backdrop_path;
        @SerializedName("adult")
        @Expose
        private boolean adult;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String release_date;

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean getVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
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

        public boolean getAdult() {
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
            return "Results{" +
                    "vote_count=" + vote_count +
                    ", id=" + id +
                    ", video=" + video +
                    ", vote_average=" + vote_average +
                    ", title='" + title + '\'' +
                    ", popularity=" + popularity +
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

    @Override
    public String toString() {
        return "MoviesResponse{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }
}
