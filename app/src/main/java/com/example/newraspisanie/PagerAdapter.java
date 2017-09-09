package com.example.newraspisanie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public static String getTitle (int position){
        if (position==1) return "Понедельник";
        if (position==2) return "Вторник";
        if (position==3) return "Среда";
        if (position==4) return "Четверг";
        if (position==5) return "Пятница";
        if (position==6) return "Суббота";
        return "";
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(PageFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

}
