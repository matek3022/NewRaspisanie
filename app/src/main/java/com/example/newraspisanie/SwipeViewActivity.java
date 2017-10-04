package com.example.newraspisanie;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.transition.ChangeBounds;
import android.support.transition.Transition;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;

import com.example.newraspisanie.adapter.TimeListAdapter;
import com.example.newraspisanie.manager.PreferenceManager;
import com.example.newraspisanie.model.DictionaryItem;
import com.example.newraspisanie.model.Para;
import com.example.newraspisanie.transition.RotateTransition;
import com.example.newraspisanie.view.DictionaryView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SwipeViewActivity extends AppCompatActivity {
    TextView toolbarTitle;
    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    Context context;
    Calendar dateAndTime = Calendar.getInstance();
    int currWeek;
    int currDay;
    String time_dayOfWeek;
    String time_hourInDay;
    private final ArrayList<DictionaryItem> numberList = new ArrayList<>();
    private final ArrayList<DictionaryItem> weekList = new ArrayList<>();
    private final ArrayList<DictionaryItem> weekDayList = new ArrayList<>();
    private final ArrayList<DictionaryItem> typeList = new ArrayList<>();

    private final ArrayList<DictionaryItem> animationList = new ArrayList<>();

    private boolean transitionProcessed = false;
    private boolean transitionPaused = false;
    private Transition.TransitionListener listener;

    private RotateTransition rotateTransition = new RotateTransition();
    private ChangeBounds chageTransition = new ChangeBounds();

    public int getNumberWindow(String dayweek, String hourday) {
        int hour = Integer.parseInt(hourday);
        switch (dayweek) {
            case "Mon":
                if (hour < 18) return 0;
                else return 1;
            case "Tue":
                if (hour < 18) return 1;
                else return 2;
            case "Wed":
                if (hour < 18) return 2;
                else return 3;
            case "Thu":
                if (hour < 18) return 3;
                else return 4;
            case "Fri":
                if (hour < 18) return 4;
                else return 5;
            case "Sat":
                if (hour < 18) return 5;
                else return 0;
            case "Sun":
                return 0;
            case "Monday":
                if (hour < 18) return 0;
                else return 1;
            case "Tuesday":
                if (hour < 18) return 1;
                else return 2;
            case "Wednesday":
                if (hour < 18) return 2;
                else return 3;
            case "Thursday":
                if (hour < 18) return 3;
                else return 4;
            case "Friday":
                if (hour < 18) return 4;
                else return 5;
            case "Saturday":
                if (hour < 18) return 5;
                else return 0;
            case "Sunday":
                return 0;
            case "пн":
                if (hour < 18) return 0;
                else return 1;
            case "вт":
                if (hour < 18) return 1;
                else return 2;
            case "ср":
                if (hour < 18) return 2;
                else return 3;
            case "чт":
                if (hour < 18) return 3;
                else return 4;
            case "пт":
                if (hour < 18) return 4;
                else return 5;
            case "сб":
                if (hour < 18) return 5;
                else return 0;
            case "вс":
                return 0;
        }
        return 0;
    }

    public boolean getChangeNextWeek(String dayweek, String hourday) {
        int hour = Integer.parseInt(hourday);
        switch (dayweek) {
            case "Sat":
                if (hour < 18) return false;
                else return true;
            case "Sun":
                return true;
            case "Saturday":
                if (hour < 18) return false;
                else return true;
            case "Sunday":
                return true;
            case "сб":
                if (hour < 18) return false;
                else return true;
            case "вс":
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view);
        initLists();
        dateAndTime.setTimeInMillis(PreferenceManager.getInstance(this).getFirstDay());
        Date dateCurr = new Date(System.currentTimeMillis());
        SimpleDateFormat hourInDay = new SimpleDateFormat("kk");
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("E");
        hourInDay.setTimeZone(TimeZone.getDefault());
        dayOfWeek.setTimeZone(TimeZone.getDefault());
        time_dayOfWeek = dayOfWeek.format(dateCurr);
        time_hourInDay = hourInDay.format(dateCurr);
        currWeek = calculateCurrWeekAndSetWeekCounter(time_dayOfWeek, time_hourInDay);
        mPagerAdapter =
                new PagerAdapter(
                        getSupportFragmentManager(), currWeek);
        mPagerAdapter.setCurrWeek(currWeek);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mViewPager.setAdapter(mPagerAdapter);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (PreferenceManager.getInstance(context).isWeekDrop()) {
                    toolbarTitle.setText(PagerAdapter.getTitle(position + 1, currWeek));
                } else {
                    toolbarTitle.setText(PagerAdapter.getTitle(position + 1));
                }
                currDay = position + 1;
            }

            @Override
            public void onPageSelected(int position) {
                /*if (position + 1 > currDay) {
                    animate(true);
                } else {
                    animate(false);
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        listener = new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {
                transitionProcessed = true;
            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {
                transitionProcessed = false;
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {
            }
        };

        Log.wtf("day_format", time_dayOfWeek + " " + time_hourInDay);
        mViewPager.setPageTransformer(true, Utils.getTransformer(PreferenceManager.getInstance(context).getAnimation()));
        mViewPager.setCurrentItem(getNumberWindow(time_dayOfWeek, time_hourInDay));
        context = this;
    }

    /*private void animate(boolean b) {
        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.sceneContainer);

        // You can also inflate a generate a Scene from a layout resource file.
        final Scene scene = Scene.getSceneForLayout(sceneRoot, b ? R.layout.scene_second : R.layout.scene_first, this);


        TransitionSet set = new TransitionSet();
        set.addTransition(rotateTransition);
        set.addTransition(chageTransition);
        // выполняться они будут одновременно
        set.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        // уставим свою длительность анимации
        set.setDuration(500);
        // и изменим Interpolator
        set.setInterpolator(new AccelerateInterpolator());
        set.addListener(listener);
        TransitionManager.go(scene, set);
    }
    private void animateBack() {
        RelativeLayout scene = (RelativeLayout) findViewById(R.id.sceneContainer);
        View square = findViewById(R.id.transition_square);
        int newSquareSize = getResources().getDimensionPixelSize(R.dimen.double_padding);

        // вызываем метод, говорящий о том, что мы хотим анимировать следующие изменения внутри sceneRoot
        TransitionManager.beginDelayedTransition(scene);

        // и применим сами изменения
        ViewGroup.LayoutParams params = square.getLayoutParams();
        params.width = newSquareSize;
        params.height = newSquareSize;
        square.setLayoutParams(params);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startSettingsDialog();
                return true;
            case R.id.week_change:
                switch (currWeek) {
                    case 1:
                        currWeek = 2;
                        showShackMessage("Четная неделя");
                        break;
                    case 2:
                        currWeek = 1;
                        showShackMessage("Нечетная неделя");
                        break;
                }
                notifyDataChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private int calculateCurrWeekAndSetWeekCounter(String dayweek, String hourday) {
        Date dateCurr = new Date(System.currentTimeMillis());
        Date dateFirst = new Date(dateAndTime.getTimeInMillis());
        SimpleDateFormat weekInYear = new SimpleDateFormat("w");
        weekInYear.setTimeZone(TimeZone.getDefault());
        int currWeek = Integer.valueOf(weekInYear.format(dateCurr));
        int firstWeek = Integer.valueOf(weekInYear.format(dateFirst));
        int numberWeek = currWeek - firstWeek + 1 + (getChangeNextWeek(dayweek, hourday) ? 1 : 0);
        ((TextView) findViewById(R.id.toolbar_sub_title)).setText(String.valueOf(numberWeek) + " неделя");
        return ((numberWeek % 2 == 0) ? 2 : 1);
    }

    private void notifyDataChanged() {
        if (PreferenceManager.getInstance(context).isWeekDrop()) {
            toolbarTitle.setText(PagerAdapter.getTitle(currDay, currWeek));
        } else {
            toolbarTitle.setText(PagerAdapter.getTitle(currDay));
        }
        mPagerAdapter.setCurrWeek(currWeek);
        mPagerAdapter.notifyDataSetChanged();
        Intent intent = new Intent(PageFragment.WEEK_CHANGE_RECEIVER_FILTER);
        intent.putExtra(PageFragment.ARG_OBJECT, currWeek);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private void startSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.alert_dialog_menu_settings, null);
        builder.setView(view);
        DictionaryView animationSelector = (DictionaryView) view.findViewById(R.id.animation);
        animationSelector.setTitle("Анимация перелистывания");
        animationSelector.setTitleVisible();
        animationSelector.setData(animationList);
        animationSelector.setSelected(PreferenceManager.getInstance(context).getAnimation());
        animationSelector.setOnDictionarySelectedListener(new DictionaryView.OnDictionarySelectedListener() {
            @Override
            public void selected(DictionaryItem dictionaryItem) {
                PreferenceManager.getInstance(context).setAnimation(dictionaryItem.getId());
                mViewPager.setPageTransformer(true, Utils.getTransformer(dictionaryItem.getId()));
                notifyDataChanged();
            }

            @Override
            public void nothingSelected() {

            }
        });
        final AlertDialog dialog = builder.create();
        view.findViewById(R.id.add_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuiUtils.displayYesAndNotMessage(context, "Вы действительно хотите поставить шаблон? Текущие данные удалятся безвозвратно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Utils.set6412List(context);
                        notifyDataChanged();
                        showShackMessage("Шаблон установлен");
                        dialog.dismiss();
                    }
                }, null);
            }
        });
        view.findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuiUtils.displayYesAndNotMessage(context, "Вы действительно хотите удалить расписание?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PreferenceManager.getInstance(context).clear();
                        notifyDataChanged();
                        showShackMessage("Данные стерты");
                        dialog.dismiss();
                    }
                }, null);
            }
        });
        ((Switch)view.findViewById(R.id.time)).setChecked(PreferenceManager.getInstance(context).isCustomTime());
        ((Switch)view.findViewById(R.id.time)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                PreferenceManager.getInstance(context).setCustomTime(b);
                if (b) {
                    showTimeChanger();
                    dialog.dismiss();
                } else {
                    notifyDataChanged();
                }
            }
        });
        ((Switch)view.findViewById(R.id.week_setting)).setChecked(PreferenceManager.getInstance(context).isWeekDrop());
        ((Switch)view.findViewById(R.id.week_setting)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                PreferenceManager.getInstance(context).setWeekDrop(b);
                notifyDataChanged();
            }
        });
        final TextView date = (TextView) view.findViewById(R.id.first_date);
        setInitialDateTime(date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SwipeViewActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        dateAndTime.set(Calendar.YEAR, year);
                        dateAndTime.set(Calendar.MONTH, monthOfYear);
                        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        setInitialDateTime(date);
                        PreferenceManager.getInstance(context).setFirstDay(dateAndTime.getTimeInMillis());
                        currWeek = calculateCurrWeekAndSetWeekCounter(time_dayOfWeek, time_hourInDay);
                        notifyDataChanged();
                    }
                },
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });
        dialog.show();
    }

    //установка кастомного времени пар
    private void showTimeChanger() {
        AlertDialog builder = new AlertDialog.Builder(context).create();
        View v = getLayoutInflater().inflate(R.layout.alert_dialog_times_settings, null);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_times);
        final TimeListAdapter adapter = new TimeListAdapter(PreferenceManager.getInstance(context).getTime());
        LinearLayoutManager ll = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(ll);
        recyclerView.setAdapter(adapter);
        builder.setView(v);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                PreferenceManager.getInstance(context).setTime(adapter.getList());
                notifyDataChanged();
                startSettingsDialog();
            }
        });
        builder.show();
        try {
            builder.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE| WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            builder.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        } catch (Exception ignored){}

    }

    // установка начальных даты и времени
    private void setInitialDateTime(TextView textView) {
        textView.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }

    private void initLists() {
        numberList.add(new DictionaryItem(1, "Первая пара"));
        numberList.add(new DictionaryItem(2, "Вторая пара"));
        numberList.add(new DictionaryItem(3, "Третья пара"));
        numberList.add(new DictionaryItem(4, "Четвертая пара"));
        numberList.add(new DictionaryItem(5, "Пятая пара"));
        numberList.add(new DictionaryItem(6, "Шестая пара"));

        weekDayList.add(new DictionaryItem(1, "Понедельник"));
        weekDayList.add(new DictionaryItem(2, "Вторник"));
        weekDayList.add(new DictionaryItem(3, "Среда"));
        weekDayList.add(new DictionaryItem(4, "Четверг"));
        weekDayList.add(new DictionaryItem(5, "Пятница"));
        weekDayList.add(new DictionaryItem(6, "Суббота"));

        weekList.add(new DictionaryItem(1, "Нечетная неделя"));
        weekList.add(new DictionaryItem(2, "Четная неделя"));

        typeList.add(new DictionaryItem(4, "Другое"));
        typeList.add(new DictionaryItem(1, "Лекция"));
        typeList.add(new DictionaryItem(2, "Практика"));
        typeList.add(new DictionaryItem(3, "Лабораторная"));

        animationList.add(new DictionaryItem(1, "Стандартная"));
        animationList.add(new DictionaryItem(2, "Уменьшение с поворотом"));
        animationList.add(new DictionaryItem(3, "Уменьшение"));
        animationList.add(new DictionaryItem(4, "Уменьшение элемента"));
        animationList.add(new DictionaryItem(5, "Адская вертикаль"));
        animationList.add(new DictionaryItem(6, "Адская горизонталь"));
        animationList.add(new DictionaryItem(7, "Адская"));
        animationList.add(new DictionaryItem(8, "Адская поэлементная"));
    }

    public void showAddDialog(Para para) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final View innerView = ((SwipeViewActivity) context).getLayoutInflater().inflate(R.layout.alert_dialog_add, null);
        builder.setView(innerView);
        final TextView name = (TextView) innerView.findViewById(R.id.name);
        final TextView auditory = (TextView) innerView.findViewById(R.id.auditory);
        final TextView prepodName = (TextView) innerView.findViewById(R.id.prepod_name);
        final TextView extended = (TextView) innerView.findViewById(R.id.extended);
        final TextView time = (TextView) innerView.findViewById(R.id.time);

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
            extended.setText(para.getExtended());
            time.setText(para.getTime());
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
                para.setExtended(extended.getText().toString());
                para.setTime(time.getText().toString());
                para.setNumber(number.getSelected().getId());
                para.setWeek(numberWeek.getSelected().getId());
                para.setWeekDay(numberDay.getSelected().getId());
                para.setTypePara(type.getSelected().getId());
                if (number.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT
                        || numberDay.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT
                        || numberWeek.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT) {
                    showAddDialog(para);
                    String snackText = "";
                    if (number.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT) {
                        snackText += "номер пары";
                    }
                    if (numberDay.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT) {
                        if (!TextUtils.isEmpty(snackText)) snackText += ", ";
                        snackText += "день недели";
                    }
                    if (numberWeek.getSelected().getId() == DictionaryView.FIRST_NOTHING_ELEMENT) {
                        if (!TextUtils.isEmpty(snackText)) snackText += ", ";
                        snackText += "неделя";
                    }
                    Snackbar.make(SwipeViewActivity.this.findViewById(R.id.root), "Пустые параметры: " + snackText, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Intent intent = new Intent(PageFragment.PARA_CHANGE_RECEIVER_FILTER + numberDay.getSelected().getId() + "_" + numberWeek.getSelected().getId());
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

    public void showShackMessage(String text) {
        Snackbar.make(SwipeViewActivity.this.findViewById(R.id.root), text, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

}


