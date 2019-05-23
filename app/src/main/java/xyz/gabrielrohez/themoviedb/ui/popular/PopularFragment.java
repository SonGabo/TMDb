package xyz.gabrielrohez.themoviedb.ui.popular;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.themoviedb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    private View view;

    public PopularFragment() {
    }

    public static PopularFragment newInstance() {
        Bundle args = new Bundle();
        PopularFragment fragment = new PopularFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popular, container, false);

        return view;
    }

}
