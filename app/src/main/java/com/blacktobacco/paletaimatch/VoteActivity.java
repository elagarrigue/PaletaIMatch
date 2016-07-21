package com.blacktobacco.paletaimatch;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;


public class VoteActivity extends AppCompatActivity {

    private  VoteActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        fragment = (VoteActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

    }

    @Override
    protected void onResume() {
        super.onResume();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onBackPressed() {

        if(!fragment.backPressed()){
            super.onBackPressed();
        }

    }
}
