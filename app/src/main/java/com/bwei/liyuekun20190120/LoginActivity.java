package com.bwei.liyuekun20190120;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwei.liyuekun20190120.fragment.FragmentOne;
import com.bwei.liyuekun20190120.fragment.FragmentTwo;
import com.hjm.bottomtabbar.BottomTabBar;

public class LoginActivity extends AppCompatActivity {

    private BottomTabBar bottomtab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bottomtab = findViewById(R.id.bottomtab);
        bottomtab.init(getSupportFragmentManager())
                .isShowDivider(true)
                .setTabPadding(4,6,10)
                .setFontSize(25)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("购物车",null,FragmentOne.class)
                .addTabItem("我的",null,FragmentTwo.class);
    }
}
