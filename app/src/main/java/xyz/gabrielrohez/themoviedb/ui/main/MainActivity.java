package xyz.gabrielrohez.themoviedb.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.ui.coming.ComingFragment;
import xyz.gabrielrohez.themoviedb.ui.popular.PopularFragment;
import xyz.gabrielrohez.themoviedb.ui.top.TopFragment;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nav_view)
    BottomNavigationView navView;

    private Fragment active;
    private TopFragment topFragment;
    private ComingFragment comingFragment;
    private FragmentManager fragmentManager;
    private PopularFragment popularFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpComponents();

    }

    private void setUpComponents() {
        topFragment = new TopFragment();
        comingFragment = new ComingFragment();
        popularFragment = new PopularFragment();
        fragmentManager = getSupportFragmentManager();
        active = topFragment;

        fragmentManager.beginTransaction().add(R.id.contentLayout, comingFragment, AppConstants.TAG_COMING).hide(comingFragment).commit();
        fragmentManager.beginTransaction().add(R.id.contentLayout, topFragment, AppConstants.TAG_TOP).hide(topFragment).commit();
        fragmentManager.beginTransaction().add(R.id.contentLayout,popularFragment, AppConstants.TAG_POPULAR).commit();

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_popular:
                    fragmentManager.beginTransaction().hide(active).show(popularFragment).commit();
                    active = popularFragment;
                    return true;
                case R.id.navigation_top:
                    fragmentManager.beginTransaction().hide(active).show(topFragment).commit();
                    active = topFragment;
                    return true;
                case R.id.navigation_coming:
                    fragmentManager.beginTransaction().hide(active).show(comingFragment).commit();
                    active = comingFragment;
                    return true;
            }
            return false;
        }
    };

}
