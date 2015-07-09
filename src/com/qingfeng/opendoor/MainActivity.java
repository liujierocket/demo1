package com.qingfeng.opendoor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements AnimationListener{
	private Button btnLeft,btnRight;
	private Animation animation_left, animation_right;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLeft = (Button) findViewById(R.id.left);
		btnRight = (Button) findViewById(R.id.right);
		//设置动画
		
		animation_left = AnimationUtils.loadAnimation(this, R.anim.anim_left);
		animation_right = AnimationUtils.loadAnimation(this, R.anim.anim_right);
		btnLeft.startAnimation(animation_left);
		btnRight.startAnimation(animation_right);
		//设置动画事件监听
		animation_left.setAnimationListener(this);
		animation_right.setAnimationListener(this);
	}
	@Override
	public void onAnimationEnd(Animation arg0) {
		btnLeft.setVisibility(View.GONE);
		btnRight.setVisibility(View.GONE);
		Intent intent = new Intent(this, Two.class);
		startActivity(intent);
		MainActivity.this.finish();
	}
	@Override
	public void onAnimationRepeat(Animation arg0) {
		
		
	}
	@Override
	public void onAnimationStart(Animation arg0) {
		
	}
	

}
