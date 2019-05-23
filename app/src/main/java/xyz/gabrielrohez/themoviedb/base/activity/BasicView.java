package xyz.gabrielrohez.themoviedb.base.activity;

import android.support.v4.app.Fragment;

public interface BasicView {
    void addFragment(Fragment fragment, final String TAG, int id);
    void replaceFragment(Fragment fragment, final String TAG, int id);
}
