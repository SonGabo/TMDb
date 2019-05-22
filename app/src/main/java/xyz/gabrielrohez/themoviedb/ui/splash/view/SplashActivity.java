package xyz.gabrielrohez.themoviedb.ui.splash.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.ui.custom.ErrorDialog;
import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenter;
import xyz.gabrielrohez.themoviedb.ui.splash.presenter.SplashPresenterIn;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @BindView(R.id.splashImage)
    ImageView image;

    private ErrorDialog dialog;
    private Animation animation;
    private FragmentManager manager;
    private SplashPresenterIn presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ButterKnife.bind(this);
        presenter = new SplashPresenter(this);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation_logo);
        image.startAnimation(animation);

        presenter.getMovies();

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);*/
    }

    /**
     * show a dialog with the error message
     * @param message   String: message to show in dialog
     */
    @Override
    public void showMessageError(String message) {
        manager = getSupportFragmentManager();
        dialog = ErrorDialog.newInstance(message);
        dialog.show(manager, AppConstants.TAG_ERROR_DIALOG);
        animation.cancel();
    }
}
