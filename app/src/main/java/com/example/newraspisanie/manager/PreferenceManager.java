package com.example.newraspisanie.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newraspisanie.model.Para;
import com.google.gson.Gson;

/**
 * Created by matek3022 on 08.09.17.
 */

public class PreferenceManager {
    private static PreferenceManager instance;
    private SharedPreferences dataPrefs;
    private Gson gson;

    public static String DATA_PREF = "com.example.newraspisanie.manager.dataPrefs";

    private static final String PARA = "com.example.newraspisanie.manager.para";
    private static final String DATE = "com.example.newraspisanie.manager.date";
    private static final String ANIMATION = "com.example.newraspisanie.manager.animation";

    private PreferenceManager(Context context){
        dataPrefs = context.getSharedPreferences(DATA_PREF, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public static PreferenceManager getInstance(Context context){
        if (instance == null) {
            instance = new PreferenceManager(context);
        }
        return instance;
    }

    public void setFirstDay(long date) {
        SharedPreferences.Editor editor = dataPrefs.edit();
        editor.putLong(DATE, date);
        editor.apply();
    }

    public long getFirstDay() {
        return dataPrefs.getLong(DATE, System.currentTimeMillis());
    }

    public Para getPara(int numberWeek, int numberDay, int number) {
        return gson.fromJson(dataPrefs.getString(PARA + numberWeek + "_" + numberDay + "_" + number, null), Para.class);
    }

    public void setPara(Para para) {
        SharedPreferences.Editor editor = dataPrefs.edit();
        editor.putString(PARA + para.getWeek() + "_" + para.getWeekDay() + "_" + para.getNumber(), gson.toJson(para));
        editor.apply();
    }

    public void setAnimation(int index) {
        SharedPreferences.Editor editor = dataPrefs.edit();
        editor.putInt(ANIMATION, index);
        editor.apply();
    }

    public int getAnimation() {
        return dataPrefs.getInt(ANIMATION, 1);
    }

    public void clearPara(int numberWeek, int numberDay, int number) {
        SharedPreferences.Editor editor = dataPrefs.edit();
        editor.remove(PARA + numberWeek + "_" + numberDay + "_" + number);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = dataPrefs.edit();
        editor.clear();
        editor.apply();
    }
}
