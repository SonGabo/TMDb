package xyz.gabrielrohez.themoviedb.ui.custom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.themoviedb.R;

public class ErrorDialog extends DialogFragment {

    @BindView(R.id.errorDialogText)
    TextView message;
    @BindView(R.id.btnDialogError)
    Button btnAccept;

    public static ErrorDialog newInstance(String message) {
        Bundle args = new Bundle();
        args.putString("message", message);
        ErrorDialog fragment = new ErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setCancelable(false);
        return inflater.inflate(R.layout.error_dialog, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater i = getActivity().getLayoutInflater();

        View view = i.inflate(R.layout.error_dialog,null);
        AlertDialog.Builder b =  new AlertDialog.Builder(getActivity());

        ButterKnife.bind(this, view);
        message.setText(getArguments().getString("message"));

        b.setView(view);
        return b.create();
    }

    @OnClick(R.id.btnDialogError)
    public void OnClick(){
        dismiss();
        getActivity().finish();
        /*if (title.getText().toString().equals(getString(R.string.please_try_again)) || title.getText().toString().equals(getString(R.string.no_info_please_try_again))){
            startActivity(new Intent(getActivity(), SplashActivity.class));
            getActivity().finish();
        }else
            getActivity().finish();*/
    }
}
