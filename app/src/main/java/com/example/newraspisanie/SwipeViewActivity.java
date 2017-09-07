package com.example.newraspisanie;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.newraspisanie.model.Para;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SwipeViewActivity extends FragmentActivity {
    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    Context context;
    public int getNumberWindow (String dayweek, String hourday){
        int hour = Integer.parseInt(hourday);
        switch (dayweek){
            case "Mon":
                if (hour<18) return 0;
                else return 1;
            case "Tue":
                if (hour<18) return 1;
                else return 2;
            case "Wed":
                if (hour<18) return 2;
                else return 3;
            case "Thu":
                if (hour<18) return 3;
                else return 4;
            case "Fri":
                if (hour<18) return 4;
                else return 5;
            case "Sat":
                if (hour<18) return 5;
                else return 0;
            case "Sun":
                return 0;
            case "Monday":
                if (hour<18) return 0;
                else return 1;
            case "Tuesday":
                if (hour<18) return 1;
                else return 2;
            case "Wednesday":
                if (hour<18) return 2;
                else return 3;
            case "Thursday":
                if (hour<18) return 3;
                else return 4;
            case "Friday":
                if (hour<18) return 4;
                else return 5;
            case "Saturday":
                if (hour<18) return 5;
                else return 0;
            case "Sunday":
                return 0;
            case "пн":
                if (hour<18) return 0;
                else return 1;
            case "вт":
                if (hour<18) return 1;
                else return 2;
            case "ср":
                if (hour<18) return 2;
                else return 3;
            case "чт":
                if (hour<18) return 3;
                else return 4;
            case "пт":
                if (hour<18) return 4;
                else return 5;
            case "сб":
                if (hour<18) return 5;
                else return 0;
            case "вс":
                return 0;
        }
        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view);
        mPagerAdapter =
                new PagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);
        PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);
        pagerTabStrip.setTabIndicatorColor(Color.WHITE);
        pagerTabStrip.setTextColor(Color.WHITE);

        Date dateCurr = new Date(System.currentTimeMillis());
        SimpleDateFormat hourInDay = new SimpleDateFormat("kk");
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("E");
        hourInDay.setTimeZone(TimeZone.getDefault());
        dayOfWeek.setTimeZone(TimeZone.getDefault());
        String time_dayOfWeek = dayOfWeek.format(dateCurr);
        String time_hourInDay = hourInDay.format(dateCurr);
        Log.wtf("day_format",time_dayOfWeek+" "+time_hourInDay);
        mViewPager.setCurrentItem(getNumberWindow(time_dayOfWeek,time_hourInDay));
        context = this;
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View innerView = ((SwipeViewActivity)context).getLayoutInflater().inflate(R.layout.layout_add, null);
                builder.setView(innerView);
                final TextView number = (TextView) innerView.findViewById(R.id.number);
                final TextView name = (TextView) innerView.findViewById(R.id.name);
                builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PageFragment.RECEIVER_FILTER);
                        intent.putExtra(PageFragment.ARG_OBJECT, new Para(Integer.valueOf(number.getText().toString()), 0, name.getText().toString(), null, null, null));
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    }
                });
                builder.setNegativeButton("Выход", null);
                builder.show();
            }
        });
    }

}


