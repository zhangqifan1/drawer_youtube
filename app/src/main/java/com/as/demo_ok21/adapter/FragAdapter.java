package com.as.demo_ok21.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/5/6.
 * ---------------------------
 */
public class FragAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public FragAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
