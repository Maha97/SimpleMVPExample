package com.doctors.simplemvpexample.main_activity.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doctors.simplemvpexample.R;
import com.doctors.simplemvpexample.main_activity.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {


    private final String TAG = MainActivity.class.getSimpleName();
    private TextView mUserDataTextView;
    private EditText mNameEdtxt;
    private EditText mfruitEdtxt;
    private ProgressBar mProgressBar;
    private MainActivityPresenter presenter;
    private FloatingActionButton mShareFab;

    private String mUserName="";
    private String mFavouriteFruit="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // Bind Views
        mUserDataTextView = findViewById(R.id.tv_user_data);
        mNameEdtxt = findViewById(R.id.et_user_name);
        mfruitEdtxt = findViewById(R.id.et_user_fruit);
        mProgressBar = findViewById(R.id.progress_bar);
        mShareFab=findViewById(R.id.fab);
        presenter = new MainActivityPresenter(this);

        initProgressBar();
        // Actions
        addListenerTofruitEditText();
        addListenerToUserNameEditText();
        onShareFloatingButtonClicked();
    }

    private void addListenerToUserNameEditText() {
        mNameEdtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.updateFullName(charSequence.toString());
                Log.d(TAG, "onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideProgressBar();
                Log.d(TAG, "afterTextChanged");
            }
        });

    }



    private  void onShareFloatingButtonClicked(){
        mShareFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserName=mNameEdtxt.getText().toString();
                mFavouriteFruit=mfruitEdtxt.getText().toString();

                 if(!TextUtils.isEmpty(mUserName)&&!TextUtils.isEmpty(mFavouriteFruit) ){
                    presenter.shareUserData(MainActivity.this,mUserName,mFavouriteFruit);
                    Log.d(TAG,"FAB Clicked");
                 }

            }
        });
    }

    private void addListenerTofruitEditText() {

        mfruitEdtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.updatefruit(charSequence.toString());
                Log.d(TAG, "onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideProgressBar();
                Log.d(TAG, "afterTextChanged");
            }
        });





    }

    private void initProgressBar() {
        mProgressBar = new ProgressBar(this, null, R.attr.progressBarStyle);
        mProgressBar.setIndeterminate(true);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels, 250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(mProgressBar, params);

        showProgressBar();


    }


    @Override
    public void updateUi(String info) {
        mUserDataTextView.setText(info);


    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void shareData() {

    }
}
