package xyz.gabrielrohez.themoviedb.ui.moviedetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.base.fragment.BasicFragment;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BasicFragment {

    @BindView(R.id.detailName)
    TextView tvName;
    @BindView(R.id.detailRate)
    TextView tvRate;
    @BindView(R.id.imageDetail)
    ImageView ivMovie;
    @BindView(R.id.detsailLaguage)
    TextView tvLanguage;
    @BindView(R.id.detailOverview)
    TextView tvOverview;
    @BindView(R.id.detailReleaseDate)
    TextView tvReleaseDate;

    private Unbinder unbinder;
    private MoviesEntity movie;

    public static DetailFragment newInstance(MoviesEntity movie) {
        Bundle args = new Bundle();
        args.putSerializable("movie", movie);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = (MoviesEntity) getArguments().getSerializable("movie");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, view);

        showInfo();
        return view;
    }

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.contentDetail)
    public void onViewClicked() {
        getFragmentManager().popBackStack();
    }
}
