package xyz.gabrielrohez.themoviedb.base.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.ui.custom.ErrorDialog;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class BasicActivity extends AppCompatActivity implements BasicView, BasicUIView {

    private ErrorDialog dialog;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showDialog(String message, int value) {
        manager = getSupportFragmentManager();
        dialog = ErrorDialog.newInstance(message, value);
        dialog.show(manager, AppConstants.TAG_ERROR_DIALOG);
    }

    @Override
    public void showLoader(boolean visible) {

    }

    @Override
    public void addFragment(Fragment fragment, String TAG, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_bottom,R.anim.slide_out_bottom );
        fragmentTransaction.add(id, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void replaceFragment(Fragment fragment, String TAG, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment, TAG);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
