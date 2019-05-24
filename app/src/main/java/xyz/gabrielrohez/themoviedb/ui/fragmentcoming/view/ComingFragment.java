package xyz.gabrielrohez.themoviedb.ui.fragmentcoming.view;


import android.annotation.SuppressLint;
import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.base.fragment.BasicFragment;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.adapter.MoviesAdapter;
import xyz.gabrielrohez.themoviedb.ui.fragmentcoming.presenter.ComingPresenter;
import xyz.gabrielrohez.themoviedb.ui.fragmentcoming.presenter.ComingPresenterIn;
import xyz.gabrielrohez.themoviedb.ui.moviedetail.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ComingFragment extends BasicFragment implements ComingView, MoviesAdapter.MoviesAdapterIn {

    @BindView(R.id.recyclerComing) RecyclerView recycler;
    @BindView(R.id.searchViewComing) SearchView searchView;
    @BindView(R.id.swipeRefreshLayoutComing) SwipeRefreshLayout refreshLayout;

    private View view;
    private Unbinder unbinder;
    private MoviesAdapter adapter;
    private List<MoviesEntity> list;
    private ComingPresenterIn presenter;

    public static ComingFragment newInstance(List<MoviesEntity> list) {
        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) list);
        ComingFragment fragment = new ComingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = (List<MoviesEntity>) getArguments().getSerializable("list");
        presenter = new ComingPresenter(basicUIView, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coming, container, false);
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
                presenter.getComingMovies();
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
     * Hide refreshlayout
     */
    @Override
    public void showRefreshLayout(boolean bool) {
        refreshLayout.setRefreshing(bool);
    }

    /**
     * New movie data is added.
     * @param movies: List<MoviesEntity> is a list of movies
     */
    @Override
    public void setNewComingMovies(List<MoviesEntity> movies) {
        list.clear();
        list.addAll(movies);
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(MoviesEntity movie) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("movie", (Serializable) movie);
        startActivity(intent);
    }
}