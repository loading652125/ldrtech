package com.zjs.ldrtech.view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.zjs.ldrtech.MainActivity;
import com.zjs.ldrtech.R;
import com.zjs.ldrtech.utils.SharePrefereceTool;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        startAmin();
    }

    private void startAmin() {
        AnimationSet animSet = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(500);
        scale.setFillAfter(true);

        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setDuration(500);
        alpha.setFillAfter(true);
        animSet.addAnimation(scale);
        animSet.addAnimation(alpha);
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPaper();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        relativeLayout.startAnimation(animSet);
    }
    public void jumpNextPaper(){
        boolean userGuide = SharePrefereceTool.getPrefBoolean(SplashActivity.this,"guide_showed",
                false);
        if (!userGuide){
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
        } else{
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        finish();
    }
}