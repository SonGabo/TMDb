package xyz.gabrielrohez.themoviedb.data.async;

import android.os.AsyncTask;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.network.model.MoviesResponse;
import xyz.gabrielrohez.themoviedb.data.room.db.AppDB;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;

public class AsyncMethods {

    //*******************************************************
    //                          Movies
    //*******************************************************

    /**
     * insert movie in databa base
     * */
    public static class InsertMovie extends AsyncTask<List<MoviesResponse.Results>, Void, List<MoviesEntity>> {

        private String type;
        private InserMovieIn listener;

        public InsertMovie(String type, InserMovieIn listener) {
            this.type = type;
            this.listener = listener;
        }

        public interface InserMovieIn {
            void storedSuccessfully(List<MoviesEntity> moviesEntities);
        }

        @Override
        protected List<MoviesEntity> doInBackground(List<MoviesResponse.Results>... lists) {
            for (MoviesResponse.Results result : lists[0]){
                MoviesEntity movies = new MoviesEntity();
                movies.setAdult(result.getAdult());
                movies.setBackdrop_path(result.getBackdrop_path());
                movies.setId_movie(result.getId());
                movies.setOriginal_language(result.getOriginal_language());
                movies.setOriginal_title(result.getOriginal_title());
                movies.setOverview(result.getOverview());
                movies.setPoster_path(result.getPoster_path());
                movies.setRelease_date(result.getRelease_date());
                movies.setTitle(result.getTitle());
                movies.setType(type);
                movies.setVideo(result.getVideo());
                movies.setVote_average(String.valueOf(result.getVote_average()));
                AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().insert(movies);
            }
            return AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().getCategory(type);
        }

        @Override
        protected void onPostExecute(List<MoviesEntity> moviesEntities) {
            listener.storedSuccessfully(moviesEntities);
        }
    }


    /**
     * get all movies in data base
     */
    public static class ReadAllMovies extends AsyncTask<Void, Void, List<MoviesEntity>> {

        private ReadAllMoviesIn listener;

        public interface ReadAllMoviesIn {
            void readSuccessfully(List<MoviesEntity> moviesList);
        }

        public ReadAllMovies(ReadAllMoviesIn listener) {
            this.listener = listener;
        }

        @Override
        protected List<MoviesEntity> doInBackground(Void... voids) {
            List<MoviesEntity> list = AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().getAllMovies();
            return list;
        }

        @Override
        protected void onPostExecute(List<MoviesEntity> moviesList) {
            listener.readSuccessfully(moviesList);
        }
    }

    /**
     * delete movie from data base
     */
    public static class DeleteMovie extends AsyncTask<MoviesEntity, Void, Void> {

        private DeleteMovieIn listener;

        public interface DeleteMovieIn {
            void deleteSuccessfully();
        }

        public DeleteMovie(DeleteMovieIn listener) {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(MoviesEntity... moviesEntities) {
            AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().delete(moviesEntities[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.deleteSuccessfully();
        }
    }

    /**
     * delete category from data base
     */
    public static class DeleteCategory extends AsyncTask<String, Void, Void> {

        private DeleteCategoryIn listener;

        public interface DeleteCategoryIn {
            void deleteSuccessfully();
        }

        public DeleteCategory(DeleteCategoryIn listener) {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(String... strings) {
            AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().deleteCategory(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.deleteSuccessfully();
        }
    }

    /**
     * delete all movies from data base
     */
    public static class DeleteAllMovies extends AsyncTask<MoviesEntity, Void, Void> {

        private DeleteAllMoviesIn listener;

        public interface DeleteAllMoviesIn {
            void deleteSuccessfully();
        }

        public DeleteAllMovies(DeleteAllMoviesIn listener) {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(MoviesEntity... moviesEntities) {
            AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().deleteAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.deleteSuccessfully();
        }
    }

    /**
     * Get list of category
     */
    public static class Category extends AsyncTask<String, Void, List<MoviesEntity>> {

        private CategoryIn listener;

        public interface CategoryIn {
            void readSuccessfully(List<MoviesEntity> moviesList);
        }

        public Category(CategoryIn listener) {
            this.listener = listener;
        }

        @Override
        protected List<MoviesEntity> doInBackground(String... strings) {
            List<MoviesEntity> list = AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().getCategory(strings[0]);
            return list;
        }

        @Override
        protected void onPostExecute(List<MoviesEntity> moviesEntityList) {
            listener.readSuccessfully(moviesEntityList);
        }
    }

    /**
     * get movie from data base
     */
    public static class GetMovie extends AsyncTask<String, Void, MoviesEntity> {

        private GetMovieIn listener;

        public interface GetMovieIn {
            void readSuccessfully(MoviesEntity moviesList);
        }

        public GetMovie(GetMovieIn listener) {
            this.listener = listener;
        }

        @Override
        protected MoviesEntity doInBackground(String... strings) {
            MoviesEntity movie = AppDB.getAppDB(AppConfig.getAppContext()).moviesDAO().getMovie(strings[0]);
            return movie;
        }

        @Override
        protected void onPostExecute(MoviesEntity moviesEntity) {
            listener.readSuccessfully(moviesEntity);
        }
    }

}
