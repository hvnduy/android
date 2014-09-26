package com.example.demoandroidanimationview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AnimationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
	       Button backButton = (Button) findViewById(R.id.backbutton);
	        backButton.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                finish();
	                overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
	            }
	        });
	}
}
