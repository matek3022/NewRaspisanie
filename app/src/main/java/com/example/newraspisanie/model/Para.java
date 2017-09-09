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
    private TypePara typePara;
    private int weekDay;
    private int week;

    public Para() {
    }

    public Para(int week, int weekDay, int number) {
        this.week = week;
        this.weekDay = weekDay;
        this.number = number;
    }

    public Para (int number, int weekDay, String name, String auditory, String namePrepod, TypePara typePara) {
        this.number = number;
        this.weekDay = weekDay;
        this.name = name;
        this.auditory = auditory;
        this.namePrepod = namePrepod;
        this.typePara = typePara;
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

    public TypePara getTypePara() {
        return typePara;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public int getWeek() {
        return week;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuditory(String auditory) {
        this.auditory = auditory;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNamePrepod(String namePrepod) {
        this.namePrepod = namePrepod;
    }

    public void setTypePara(TypePara typePara) {
        this.typePara = typePara;
    }
    public void setTypePara(int idPara) {
        switch (idPara) {
            case 1:
                typePara = TypePara.LEKCIA;
                break;
            case 2:
                typePara = TypePara.PRACTIC;
                break;
            case 3:
                typePara = TypePara.LABA;
                break;
        }
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public enum TypePara {
        LEKCIA("Лекция", 1),
        PRACTIC("Практика", 2),
        LABA("Лабораторная", 3);
        private String value;
        private int id;
        TypePara (String value, int id) {
            this.value = value;
            this.id = id;
        }

        @Override
        public String toString() {
            return value;
        }

        public int getId() {
            return id;
        }
    }
}