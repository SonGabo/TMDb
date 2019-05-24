package xyz.gabrielrohez.themoviedb.ui.main.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.base.activity.BasicActivity;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.adapter.SectionPagerAdapter;
import xyz.gabrielrohez.themoviedb.ui.main.presenter.MainPresenter;
import xyz.gabrielrohez.themoviedb.ui.main.presenter.MainPresenterIn;

public class MainActivity extends BasicActivity implements MainView {

    @BindView(R.id.tabs)TabLayout tabs;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.container)ViewPager viewPager;

    private MainPresenterIn presenter;
    private SectionPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        presenter = new MainPresenter(this);
        presenter.getPopularMovies();
    }

    @Override
    public void setCategoryMovies(List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList) {
        setUpPager(popularList, topList, comingList);
    }

    private void setUpPager(List<MoviesEntity> popularList, List<MoviesEntity> topList, List<MoviesEntity> comingList) {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), popularList, topList, comingList);

        // Set up the ViewPager with the sections adapter.
        viewPager.setAdapter(mSectionsPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}