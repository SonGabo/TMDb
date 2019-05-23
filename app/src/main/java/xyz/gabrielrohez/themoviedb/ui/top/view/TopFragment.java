package xyz.gabrielrohez.themoviedb.ui.top.view;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

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

    @BindView(R.id.searchViewTop)
    SearchView searchView;
    @BindView(R.id.recyclerTop)
    RecyclerView recycler;

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

        setUpRecycler();
        return view;
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
