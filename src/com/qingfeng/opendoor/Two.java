package com.qingfeng.opendoor;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Two extends Activity {
	private ImageView iv_bomb;
	private ImageView iv_rocket;
	private Button bt_fire;
	private Button bt_lauch;
	// 实现动画平移
	private Animation translate_rocket;
	// 实现主政动画
	private AnimationDrawable bombDrawble;
	private AnimationDrawable rocketDrawble;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		// 初始化视图
		initView();
		listener();
	}

	private void listener() {
		translate_rocket.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				bombDrawble.start();
				rocketDrawble.setVisible(false, false);
				//bt_fire.setVisibility(View.GONE);
				//bt_lauch.setVisibility(View.GONE);
			}
		});
		
		//设置点火按钮监听
		bt_fire.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				rocketDrawble.start();

			}
		});
		
		//设置发射按钮监听
		bt_lauch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(!rocketDrawble.isRunning()){
					Toast.makeText(getApplicationContext(), "请先点火！！", Toast.LENGTH_SHORT).show();
				}
				
				iv_rocket.startAnimation(translate_rocket);
				
				
			}
		});
	}

	private void initView() {
		iv_bomb = (ImageView) findViewById(R.id.iv_bomb);
		iv_rocket = (ImageView) findViewById(R.id.iv_rocket);
		bt_fire = (Button) findViewById(R.id.bt_fire);
		bt_lauch = (Button) findViewById(R.id.bt_launch);
		translate_rocket = AnimationUtils.loadAnimation(this,
				R.anim.translate_rocket);
		// translate_bomb = AnimationUtils.loadAnimation(this, R.anim.);

		// 获取AnimationDrawable对象
		bombDrawble = (AnimationDrawable) iv_bomb.getBackground();
		rocketDrawble = (AnimationDrawable) iv_rocket.getBackground();
		
	}

}
