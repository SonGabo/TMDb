package xyz.gabrielrohez.themoviedb.ui.top;


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
public class TopFragment extends Fragment {

    private View view;

    public TopFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top, container, false);

        return view;
    }

}
