package xyz.gabrielrohez.themoviedb.ui.top.view;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.ui.adapter.MoviesAdapter;

/**
 * A simple {@link Fragment} subclass.
 */

@SuppressLint("ValidFragment")
public class TopFragment extends Fragment implements TopView, MoviesAdapter.MoviesAdapterIn {

    @BindView(R.id.recyclerTop) RecyclerView recycler;
    @BindView(R.id.searchViewTop) SearchView searchView;
    @BindView(R.id.swipeRefreshLayoutTop) SwipeRefreshLayout refreshLayout;

    private View view;
    private Unbinder unbinder;
    private MoviesAdapter adapter;
    private List<MoviesEntity> list;

    public TopFragment(List<MoviesEntity> topList) {
        this.list = topList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top, container, false);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesAdapter(list, this);

        setUpEvents();
        setUpRecycler();
        return view;
    }

    private void setUpEvents() {

        refreshLayout.setColorSchemeResources(R.color.colorWhite);
        refreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

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
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(MoviesEntity movie) {

    }
}
