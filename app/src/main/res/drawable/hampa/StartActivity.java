package com.arayeh.hampa;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.imgLogo) ImageView mImgLogo;
    private Animation animation;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        mImgLogo.startAnimation(animation);
        timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimrTask(), 2000, 4000);

    }

    public class MyTimrTask extends TimerTask {

        @Override
        public void run() {
            StartActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    timer.cancel();
                    finish();
                }
            });
        }
    }
}
