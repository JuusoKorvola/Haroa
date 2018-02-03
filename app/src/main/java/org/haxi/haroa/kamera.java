package org.haxi.haroa;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class kamera extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        final ImageView scrolling = (ImageView) findViewById(R.id.ahh);

        final Button next = (Button) findViewById(R.id.nextbutton);
        next.setVisibility(View.GONE);




        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(scrolling, "scaleX",2.1f);
        scaleX1.setDuration(8000);
        scaleX1.start();
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(scrolling, "scaleY",2.1f);
        scaleY1.setDuration(8000);
        scaleY1.start();
        ObjectAnimator scrollX1 = ObjectAnimator.ofInt(scrolling, "scrollX",10);
        scrollX1.setDuration(8000);
        scrollX1.start();
        ObjectAnimator scrollY1 = ObjectAnimator.ofInt(scrolling, "scrollY",10);
        scrollY1.setDuration(8000);
        scrollY1.start();

        final MediaPlayer musa = MediaPlayer.create(this, R.raw.apex);
        musa.start();

        ObjectAnimator scaleX2 = ObjectAnimator.ofFloat(scrolling, "scaleX",5);
        scaleX2.setDuration(4000);
        scaleX2.setStartDelay(8000);
        scaleX2.start();
        ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(scrolling, "scaleY",5);
        scaleY2.setDuration(4000);
        scaleY2.setStartDelay(8000);
        scaleY2.start();
        ObjectAnimator scrollX2 = ObjectAnimator.ofInt(scrolling, "scrollX",-40);
        scrollX2.setDuration(4000);
        scrollX2.setStartDelay(8000);
        scrollX2.start();
        ObjectAnimator scrollY2 = ObjectAnimator.ofInt(scrolling, "scrollY",160);
        scrollY2.setDuration(4000);
        scrollY2.setStartDelay(8000);
        scrollY2.start();

        ObjectAnimator scrollX3 = ObjectAnimator.ofInt(scrolling, "scrollX",60);
        scrollX3.setDuration(4000);
        scrollX3.setStartDelay(12000);
        scrollX3.start();

        ObjectAnimator scaleX4 = ObjectAnimator.ofFloat(scrolling, "scaleX",2.1f);
        scaleX4.setDuration(4000);
        scaleX4.setStartDelay(16000);
        scaleX4.start();
        ObjectAnimator scaleY4 = ObjectAnimator.ofFloat(scrolling, "scaleY",2.1f);
        scaleY4.setDuration(4000);
        scaleY4.setStartDelay(16000);
        scaleY4.start();
        ObjectAnimator scrollX4 = ObjectAnimator.ofInt(scrolling, "scrollX",0);
        scrollX4.setDuration(4000);
        scrollX4.setStartDelay(16000);
        scrollX4.start();
        ObjectAnimator scrollY4 = ObjectAnimator.ofInt(scrolling, "scrollY",0);
        scrollY4.setDuration(4000);
        scrollY4.setStartDelay(16000);
        scrollY4.start();

        final Handler handel = new Handler();
        handel.postDelayed(new Runnable() {
            @Override
            public void run() {
                next.setVisibility(View.VISIBLE);
                Animation scroll = new TranslateAnimation(-0,0,0,-1500);
                scroll.setDuration(8000);
                scroll.setFillAfter(true);
                scroll.setInterpolator(new LinearInterpolator());
                next.setAnimation(scroll);
                handel.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        launchNextActivity(musa);
                    }
                },18000);
            }
        },21500);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNextActivity(musa);
            }
        });



    }

    public void launchNextActivity(MediaPlayer musa) {
        Intent intent = new Intent(this, Mane.class);
        musa.stop();
        startActivity(intent);
    }
}
