package com.example.newraspisanie;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newraspisanie.manager.PreferenceManager;
import com.example.newraspisanie.model.DictionaryItem;
import com.example.newraspisanie.model.Para;
import com.example.newraspisanie.view.DictionaryView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class SwipeViewActivity extends FragmentActivity {
    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    Context context;
    private final ArrayList<DictionaryItem> numberList = new ArrayList<>();
    private final ArrayList<DictionaryItem> weekList = new ArrayList<>();
    private final ArrayList<DictionaryItem> weekDayList = new ArrayList<>();
    private final ArrayList<DictionaryItem> typeList = new ArrayList<>();

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
        initLists();
        mPagerAdapter =
                new PagerAdapter(
                        getSupportFragmentManager());
        WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
        Drawable drawable = wm.getFastDrawable();
        (findViewById(R.id.pager)).setBackground(drawable);
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
                showAddDialog();
            }
        });
    }

    private void initLists() {
        numberList.add(new DictionaryItem(1, "Первая"));
        numberList.add(new DictionaryItem(2, "Вторая"));
        numberList.add(new DictionaryItem(3, "Третья"));
        numberList.add(new DictionaryItem(4, "Четвертая"));
        numberList.add(new DictionaryItem(5, "Пятая"));
        numberList.add(new DictionaryItem(6, "Шестая"));

        weekDayList.add(new DictionaryItem(1, "Понедельник"));
        weekDayList.add(new DictionaryItem(2, "Вторник"));
        weekDayList.add(new DictionaryItem(3, "Среда"));
        weekDayList.add(new DictionaryItem(4, "Четверг"));
        weekDayList.add(new DictionaryItem(5, "Пятница"));
        weekDayList.add(new DictionaryItem(6, "Суббота"));

        weekList.add(new DictionaryItem(1, "Нечетная"));
        weekList.add(new DictionaryItem(2, "Четная"));

        typeList.add(new DictionaryItem(1, "Лекция"));
        typeList.add(new DictionaryItem(2, "Практика"));
        typeList.add(new DictionaryItem(3, "Лабораторная"));
    }

    public void showAddDialog(Para para) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final View innerView = ((SwipeViewActivity)context).getLayoutInflater().inflate(R.layout.layout_add, null);
        builder.setView(innerView);
        final TextView name = (TextView) innerView.findViewById(R.id.name);
        final TextView auditory = (TextView) innerView.findViewById(R.id.auditory);
        final TextView prepodName = (TextView) innerView.findViewById(R.id.prepod_name);

        final DictionaryView number = (DictionaryView) innerView.findViewById(R.id.number);
        final DictionaryView numberDay = (DictionaryView) innerView.findViewById(R.id.week_day);
        final DictionaryView numberWeek = (DictionaryView) innerView.findViewById(R.id.numberWeek);
        final DictionaryView type = (DictionaryView) innerView.findViewById(R.id.type);
        number.setAddFirstNothingElement(true);
        number.setTitleFirstNothingElement("Номер пары");
        number.setData(numberList);

        numberDay.setAddFirstNothingElement(true);
        numberDay.setTitleFirstNothingElement("День недели");
        numberDay.setData(weekDayList);

        numberWeek.setAddFirstNothingElement(true);
        numberWeek.setTitleFirstNothingElement("Четность недели");
        numberWeek.setData(weekList);

        type.setAddFirstNothingElement(true);
        type.setTitleFirstNothingElement("Тип пары");
        type.setData(typeList);

        if (para != null) {
            name.setText(para.getName());
            auditory.setText(para.getAuditory());
            prepodName.setText(para.getNamePrepod());
            number.setSelected(para.getNumber());
            numberDay.setSelected(para.getWeekDay());
            numberWeek.setSelected(para.getWeek());
            if (para.getTypePara() != null)
                type.setSelected(para.getTypePara().getId());
        }
        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Para para = new Para();
                para.setAuditory(auditory.getText().toString());
                para.setName(name.getText().toString());
                para.setNamePrepod(prepodName.getText().toString());
                para.setNumber(number.getSelected().getId());
                para.setWeek(numberWeek.getSelected().getId());
                para.setWeekDay(numberDay.getSelected().getId());
                para.setTypePara(type.getSelected().getId());
                if (number.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT
                        || numberDay.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT
                        || numberWeek.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT
                        || type.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT) {
                    showAddDialog(para);
                    Toast.makeText(context, "Пустые параметры: неделя/день недели/номер пары/тип пары", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(PageFragment.RECEIVER_FILTER + numberDay.getSelected().getId() + "_" + numberWeek.getSelected().getId());
                    PreferenceManager.getInstance(context).setPara(para);
                    intent.putExtra(PageFragment.ARG_OBJECT, para);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            }
        });
        builder.setNegativeButton("Выход", null);
        builder.show();
    }

    public void showAddDialog() {
        showAddDialog(null);
    }

}


