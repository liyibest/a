package com.example.lee.scandemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.animation.*;

public class MainActivity extends AppCompatActivity {

    private ImageView  mScanHorizontalLineImageView;
    private View  mPreviewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScanHorizontalLineImageView= (ImageView) findViewById(R.id.scanHorizontalLineImageView);
        mPreviewView = findViewById(R.id.priewView);


    }
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);

        int[] location = new int[2];

        // getLocationInWindow方法要在onWindowFocusChanged方法里面调用
        mPreviewView.getLocationInWindow(location);

        // 模拟的mPreviewView的左右上下坐标坐标
//        int left = mPreviewView.getLeft();
//        int right = mPreviewView.getRight();
        int top = mPreviewView.getTop();
        int bottom = mPreviewView.getBottom();

        // 从上到下的平移动画
        Animation HorizontalAnimation = new TranslateAnimation(0, 0, top, bottom);
        HorizontalAnimation.setDuration(4000); // 动画持续时间
        HorizontalAnimation.setRepeatCount(Animation.INFINITE); // 无限循环
        Animation HorizontalAnimation2=new TranslateAnimation(0,0,bottom,top);
//        HorizontalAnimation2.setDuration(400);
//        HorizontalAnimation2.setRepeatCount(Animation.INFINITE);//


        // 播放动画
        mScanHorizontalLineImageView.setAnimation(HorizontalAnimation);
        HorizontalAnimation.startNow();
//        mScanHorizontalLineImageView.setAnimation(HorizontalAnimation2);
//        HorizontalAnimation2.startNow();

    }
}
