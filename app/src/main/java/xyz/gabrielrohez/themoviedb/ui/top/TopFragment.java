package xyz.gabrielrohez.themoviedb.ui.top;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;

/**
 * A simple {@link Fragment} subclass.
 */

@SuppressLint("ValidFragment")
public class TopFragment extends Fragment {

    private View view;
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
        Log.d("top", list.size()+"");

        return view;
    }

}
