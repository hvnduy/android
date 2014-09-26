package com.example.demoandroidanimationview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainAnimationActivity extends Activity {

    LinearLayout screen;
    Button switchButton;
    ImageView bigIcon;
    ImageView icon;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animation);
 
        screen = (LinearLayout) findViewById(R.id.screen);
        bigIcon = (ImageView) findViewById(R.id.bigicon);
        icon = (ImageView) findViewById(R.id.icon);
 
        switchButton = (Button) findViewById(R.id.switchbutton);
        switchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainAnimationActivity.this, AnimationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
 
        Animation animRightIn = AnimationUtils.loadAnimation(this, R.anim.right_in);
        Animation animRotateIn_icon = AnimationUtils.loadAnimation(this, R.anim.rotate);
 
        screen.startAnimation(animRightIn);
        icon.startAnimation(animRotateIn_icon);
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        Animation animRotateIn_big = AnimationUtils.loadAnimation(this, R.anim.rotate);
        bigIcon.startAnimation(animRotateIn_big);
    }
}
