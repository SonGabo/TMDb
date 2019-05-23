package xyz.gabrielrohez.themoviedb.ui.coming;


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
public class ComingFragment extends Fragment {

    private View view;

    public ComingFragment() {
    }

    public static ComingFragment newInstance() {
        Bundle args = new Bundle();
        ComingFragment fragment = new ComingFragment();
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
        view = inflater.inflate(R.layout.fragment_coming, container, false);

        return view;
    }

}
