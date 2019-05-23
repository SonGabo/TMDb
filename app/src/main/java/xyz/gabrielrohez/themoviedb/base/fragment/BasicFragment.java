package xyz.gabrielrohez.themoviedb.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import xyz.gabrielrohez.themoviedb.base.activity.BasicUIView;
import xyz.gabrielrohez.themoviedb.base.activity.BasicView;

public class BasicFragment extends Fragment {

    public BasicView basicView;
    public BasicUIView basicUIView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        basicView = (BasicView)context;
        basicUIView = (BasicUIView)context;
    }
}
