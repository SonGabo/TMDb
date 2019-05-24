package xyz.gabrielrohez.themoviedb.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import xyz.gabrielrohez.themoviedb.R;

public class AppConfig extends Application {

    public static AndroidResourceManager androidResourceManager;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        androidResourceManager = new AndroidResourceManager(getResources());
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public class AndroidResourceManager {

        private Resources resources;

        public AndroidResourceManager(Resources resources) {
            this.resources = resources;
        }

        public String getMessageWithoutInternetConnection() {
            return resources.getString(R.string.no_internet_conecction);
        }

        public String getMessageRetrofitFailure() {
            return resources.getString(R.string.retrofit_failure);
        }

        public String getMessageNoDataAvailable() {
            return resources.getString(R.string.no_data_available);
        }

        public String getMessageError() {
            return resources.getString(R.string.error_consulting);
        }

        public String getTypePopular() {
            return resources.getString(R.string.popular);
        }

        public String getTopRated() {
            return resources.getString(R.string.top_rated);
        }

        public String getUpcoming() {
            return resources.getString(R.string.upcoming);
        }

        public String getVideoNotAvaible() {
            return resources.getString(R.string.video_no_available);
        }
    }
}
