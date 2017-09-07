package com.example.newraspisanie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

// adapter for ViewPager
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public int getDrawableImage (int position){
        if (position==1) return R.drawable.i1;
        if (position==2) return R.drawable.i2;
        if (position==3) return R.drawable.i3;
        if (position==4) return R.drawable.i4;
        if (position==5) return R.drawable.i5;
        if (position==6) return R.drawable.i6;
        return 0;
    }
    public String getTitle (int position){
        if (position==1) return "MON";
        if (position==2) return "TUE";
        if (position==3) return "WED";
        if (position==4) return "THU";
        if (position==5) return "FRI";
        if (position==6) return "SAT";
        return "";
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PageFragment();

        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(PageFragment.ARG_OBJECT, getDrawableImage(i+1));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getTitle(position+1);
    }
}
