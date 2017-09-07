package com.example.newraspisanie.model;

import java.io.Serializable;

/**
 * Created by matek on 07.09.2017.
 */

public class Para implements Serializable{
    private String time;
    private String name;
    private String auditory;
    private int number;
    private String namePrepod;
    private Type type;
    private int weekDay;

    public Para (int number, int weekDay, String name, String auditory, String namePrepod, Type type) {
        this.number = number;
        this.weekDay = weekDay;
        this.name = name;
        this.auditory = auditory;
        this.namePrepod = namePrepod;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getAuditory() {
        return auditory;
    }

    public int getNumber() {
        return number;
    }

    public String getNamePrepod() {
        return namePrepod;
    }

    public Type getType() {
        return type;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public enum Type {
        LABA,
        LEKCIA,
        PRACTIC
    }
}
