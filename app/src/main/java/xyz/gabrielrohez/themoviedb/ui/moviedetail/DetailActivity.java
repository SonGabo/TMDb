package xyz.gabrielrohez.themoviedb.ui.moviedetail;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detailName) TextView tvName;
    @BindView(R.id.detailRate) TextView tvRate;
    @BindView(R.id.imageDetail) ImageView ivMovie;
    @BindView(R.id.detsailLaguage) TextView tvLanguage;
    @BindView(R.id.detailOverview) TextView tvOverview;
    @BindView(R.id.detailReleaseDate) TextView tvReleaseDate;

    private MoviesEntity movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setElevation(0);
        ButterKnife.bind(this);

        movie = (MoviesEntity) getIntent().getSerializableExtra("movie");

        showInfo();

    }

    /**
     * show detail of movie in edittext
     */
    private void showInfo() {
        tvName.setText(movie.getOriginal_title());
        tvRate.setText(movie.getVote_average());
        tvLanguage.setText(movie.getOriginal_language());
        tvOverview.setText(movie.getOverview());
        tvReleaseDate.setText(movie.getRelease_date());
        Glide.with(AppConfig.getAppContext())
                .load(AppConstants.BASE_URL_IMAGE+movie.getPoster_path())
                .placeholder(R.drawable.default_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(ivMovie);
    }

    @OnClick(R.id.contentDetail)
    public void onViewClicked() {
        getFragmentManager().popBackStack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
