package xyz.gabrielrohez.themoviedb.ui.moviedetail.view;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.circularrevelation.MyCircularRevelation;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter.DetailPresenter;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.presenter.DetailPresenterIn;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.detailName) TextView tvName;
    @BindView(R.id.detailRate) TextView tvRate;
    @BindView(R.id.imageDetail) ImageView ivMovie;
    @BindView(R.id.detsailLaguage) TextView tvLanguage;
    @BindView(R.id.detailOverview) TextView tvOverview;
    @BindView(R.id.detailReleaseDate) TextView tvReleaseDate;

    private int revealX;
    private int revealY;
    private View rootLayout;
    private MoviesEntity movie;
    private DetailPresenterIn presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        setUpReveal(savedInstanceState);
        ButterKnife.bind(this);
        setTitle(getString(R.string.detail));
        presenter = new DetailPresenter(this);

        //  show arrow back in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //  hide elevation in action bar
        getSupportActionBar().setElevation(0);

        //  get movie object
        movie = (MoviesEntity) getIntent().getSerializableExtra("movie");

        showInfo();
        presenter.getKeyFromVideo(movie.getId_movie());

    }

    /**
     * shows the animation when opening the activity
     */
    private void setUpReveal(Bundle savedInstanceState) {
        final Intent intent = getIntent();
        rootLayout = findViewById(R.id.contentDetail);
        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                intent.hasExtra(AppConstants.EXTRA_CIRCULAR_REVEAL_X) &&
                intent.hasExtra(AppConstants.EXTRA_CIRCULAR_REVEAL_Y)) {
            rootLayout.setVisibility(View.INVISIBLE);

            revealX = intent.getIntExtra(AppConstants.EXTRA_CIRCULAR_REVEAL_X, 0);
            revealY = intent.getIntExtra(AppConstants.EXTRA_CIRCULAR_REVEAL_Y, 0);


            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        MyCircularRevelation.revealActivity(revealX, revealY,rootLayout, DetailActivity.this);
                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            rootLayout.setVisibility(View.VISIBLE);
        }
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

    /**
     * you get the url of the video and it shows on the screen
     */
    @Override
    public void loadVideo(String url) {
        Log.d("url_video", url);
    }

    /**
     * message shown when the video is unavailable
     */
    @Override
    public void videoNotAailable(String message) {
        Log.d("url_video", message);
    }
}
