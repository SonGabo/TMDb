package xyz.gabrielrohez.themoviedb.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

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

    }
}
