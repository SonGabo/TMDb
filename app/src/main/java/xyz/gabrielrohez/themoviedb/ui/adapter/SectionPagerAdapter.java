package xyz.gabrielrohez.themoviedb.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.coming.view.ComingFragment;
import xyz.gabrielrohez.themoviedb.ui.popular.view.PopularFragment;
import xyz.gabrielrohez.themoviedb.ui.top.view.TopFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 3;
    private List<MoviesEntity> popularList;
    private List<MoviesEntity> topList;
    private List<MoviesEntity> comingList;

    public SectionPagerAdapter(FragmentManager fragmentManager, List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList) {
        super(fragmentManager);
        this.popularList = popularList;
        this.topList = topList;
        this.comingList = comingList;

    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PopularFragment.newInstance(popularList);
            case 1:
                return TopFragment.newInstance(topList);
            case 2:
                return ComingFragment.newInstance(comingList);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "POPULAR";
            case 1: return "TOP";
            case 2: return "COMING";
        }
        return "";
    }

}
