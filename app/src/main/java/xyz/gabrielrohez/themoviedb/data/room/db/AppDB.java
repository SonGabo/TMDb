package xyz.gabrielrohez.themoviedb.data.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.gabrielrohez.themoviedb.data.room.dao.MoviesDAO;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

@Database(entities = MoviesEntity.class, version = 1)
public abstract class AppDB extends RoomDatabase {

    public static AppDB INSTANCE;
    public abstract MoviesDAO moviesDAO();

    public static AppDB getAppDB(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDB.class, AppConstants.NAME_DATABASE)
                    .allowMainThreadQueries() // Allows queries in the main thread.
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
