package xyz.gabrielrohez.themoviedb.ui.popular.view;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.base.fragment.BasicFragment;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.adapter.MoviesAdapter;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.DetailFragment;
import xyz.gabrielrohez.themoviedb.ui.popular.presenter.PopularPresenter;
import xyz.gabrielrohez.themoviedb.ui.popular.presenter.PopularPresenterIn;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class PopularFragment extends BasicFragment implements PopularView, MoviesAdapter.MoviesAdapterIn {

    @BindView(R.id.recyclerPopular) RecyclerView recycler;
    @BindView(R.id.searchViewPopular) SearchView searchView;
    @BindView(R.id.swipeRefreshLayoutPopular) SwipeRefreshLayout refreshLayout;

    private View view;
    private Unbinder unbinder;
    private MoviesAdapter adapter;
    private List<MoviesEntity> list;
    private PopularPresenterIn presenter;

    public PopularFragment(List<MoviesEntity> popularList) {
        this.list = popularList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PopularPresenter(basicUIView, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popular, container, false);
        unbinder = ButterKnife.bind(this, view);

        setUpEvents();
        setUpRecycler();
        return view;
    }

    /**
     * events in refrshlayout and searchview
     */
    private void setUpEvents() {

        refreshLayout.setColorSchemeResources(R.color.colorWhite);
        refreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getPopularMovies();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String userInput  = newText.toLowerCase();
                List<MoviesEntity> newList = new ArrayList<>();
                for (MoviesEntity moviesEntity : list){
                    if (moviesEntity.getOriginal_title().toLowerCase().contains(userInput)){
                        newList.add(moviesEntity);
                    }
                }
                adapter.updateList(newList);
                return true;
            }
        });
    }

    /**
     * Recyclerview configuration
     */
    private void setUpRecycler() {
        adapter = new MoviesAdapter(list, this);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * New movie data is added.
     * @param movies: List<MoviesEntity> is a list of movies
     */
    @Override
    public void setNewPopularMovies(List<MoviesEntity> movies) {
        list.clear();
        list.addAll(movies);
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    /**
     * Hide refreshlayout
     */
    @Override
    public void showRefreshLayout(boolean bool) {
        refreshLayout.setRefreshing(bool);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(MoviesEntity movie) {
        basicView.addFragment(DetailFragment.newInstance(movie), AppConstants.TAG_DETAIL, R.id.contentLayout);
    }
}