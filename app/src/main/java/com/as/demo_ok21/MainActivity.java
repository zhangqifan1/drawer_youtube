package com.as.demo_ok21;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.as.demo_ok21.adapter.FragAdapter;
import com.as.demo_ok21.fragment.FirstFragment;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"酷狗", "QQ", "酷我", "网易云"};

    private boolean isDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new FirstFragment());
        list.add(new FirstFragment());
        list.add(new FirstFragment());

        FragAdapter fragAdapter = new FragAdapter(getSupportFragmentManager(), list);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewpager = findViewById(R.id.viewpager);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        final CoordinatorLayout drawer_right = findViewById(R.id.drawer_right);
        final NavigationView drawer_left = findViewById(R.id.drawer_left);

        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }

        tabLayout.setupWithViewPager(viewpager);

        viewpager.setAdapter(fragAdapter);

        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
        //不可兼得
//        drawer_right.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(isDrawer){
//                    return drawer_left.dispatchTouchEvent(motionEvent);
//                }else{
//                    return false;
//                }
//            }
//        });
//
//        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                isDrawer=true;
//                //获取屏幕的宽高
//                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//                Display display = manager.getDefaultDisplay();
//                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
//                drawer_right.layout(drawer_left.getRight(), 0, drawer_left.getRight() + display.getWidth(), display.getHeight());
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                isDrawer=false;
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//            }
//        });
    }
}
