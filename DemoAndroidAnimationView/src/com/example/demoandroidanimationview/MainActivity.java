package com.example.demoandroidanimationview;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
 
public class MainActivity extends Activity {
 
    CheckBox mCheckBox;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);
        final Button alphaButton = (Button) findViewById(R.id.alphaButton);
        final Button translateButton = (Button) findViewById(R.id.translateButton);
        final Button rotateButton = (Button) findViewById(R.id.rotateButton);
        final Button scaleButton = (Button) findViewById(R.id.scaleButton);
        final Button setButton = (Button) findViewById(R.id.setButton);
 
        //Animation làm mờ đi 1 nút
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        //Thời gian làm mờ nút
        alphaAnimation.setDuration(3000);
 
        //Animation di chuyển 1 nút
        final TranslateAnimation translateAnimation =
                new TranslateAnimation(Animation.ABSOLUTE, 0,
                Animation.RELATIVE_TO_PARENT, 1,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 100);
        //Tổng thời gian di chuyển
        translateAnimation.setDuration(3000);
 
        //Xoay nút một vòng tròn (360 độ)
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        //Tổng thời gian xoay nút
        rotateAnimation.setDuration(3000);
 
        //Thiết lập quy mô to nhỏ cho nút
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
        //Thiết lập thời gian thực hiện
        scaleAnimation.setDuration(3000);
 
        //Tổng hợp các animation ở trên
        final AnimationSet setAnimation = new AnimationSet(true);
        setAnimation.addAnimation(alphaAnimation);
        setAnimation.addAnimation(translateAnimation);
        setAnimation.addAnimation(rotateAnimation);
        setAnimation.addAnimation(scaleAnimation);
 
        setupAnimation(alphaButton, alphaAnimation, R.anim.alpha_anim);
        setupAnimation(translateButton, translateAnimation, R.anim.translate_anim);
        setupAnimation(rotateButton, rotateAnimation, R.anim.rotate_anim);
        setupAnimation(scaleButton, scaleAnimation, R.anim.scale_anim);
        setupAnimation(setButton, setAnimation, R.anim.set_anim);
 
    }
 
    private void setupAnimation(View view, final Animation animation,
            final int animationID) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Nếu được chọn, thực hiện animation từ nguồn code ở trên
                // Nếu không được chọn thì thực hiện animation từ xml (res/anim/)
                v.startAnimation(mCheckBox.isChecked() ? AnimationUtils.loadAnimation(MainActivity.this, animationID) : animation);
            }
        });
    }
}