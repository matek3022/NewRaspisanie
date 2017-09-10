package com.example.newraspisanie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int currWeek;
    public PagerAdapter(FragmentManager fm, int currWeek) {
        super(fm);
        this.currWeek = currWeek;
    }

    public void setCurrWeek(int currWeek) {
        this.currWeek = currWeek;
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

    public static String getTitle (int position, int week){
        String res = week == 1 ? "I - " : "II - ";
        if (position==1) res+= "Понедельник";
        if (position==2) res+= "Вторник";
        if (position==3) res+= "Среда";
        if (position==4) res+= "Четверг";
        if (position==5) res+= "Пятница";
        if (position==6) res+= "Суббота";
        return res;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(PageFragment.ARG_OBJECT, i + 1);
        args.putInt(PageFragment.ARG_CURR_WEEK, currWeek);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

}
