package com.zhzk.shopping.common.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.zhzk.shopping.R;
import com.zhzk.shopping.base.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
        changeDaohang();
//        changeDaohang1();
    }

    private void changeDaohang1() {
        Window window = getWindow();
//取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色
        window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.icon));
//        window.setStatusBarColor(ContextCompat.getColor(this,R.color.navigation_bar_index));

        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
            ViewCompat.setFitsSystemWindows(mChildView, true);
        }
    }

    private void changeDaohang() {
        Window window = getWindow();
        //设置透明状态栏,这样才能让 ContentView 向上
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 设置成透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //设置状态栏颜色
//        window.setStatusBarColor(ContextCompat.getColor(this,R.color.navigation_bar_index));
//        window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.icon));

        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
            // toolbar会占据状态栏的位置
            ViewCompat.setFitsSystemWindows(mChildView,false);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
