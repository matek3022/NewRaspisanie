package com.example.newraspisanie.model;

import java.io.Serializable;

/**
 * Created by matek on 07.09.2017.
 */

public class Para implements Serializable {
    private String name;
    private String auditory;
    private int number;
    private String namePrepod;
    private TypePara typePara = null;
    private int weekDay;
    private int week;
    private String extended;

    public Para() {
    }

    public Para(int week, int weekDay, int number) {
        this.week = week;
        this.weekDay = weekDay;
        this.number = number;
    }

    public Para(int week, int weekDay, int number, String name, String namePrepod, String auditory, TypePara typePara, String extended) {
        this.number = number;
        this.weekDay = weekDay;
        this.week = week;
        this.name = name;
        this.auditory = auditory;
        this.namePrepod = namePrepod;
        this.typePara = typePara;
        this.extended = extended;
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

    public String getExtended() {
        return extended;
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
            default:
                typePara = null;
        }
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setExtended(String extended) {
        this.extended = extended;
    }

    public enum TypePara {
        LEKCIA("Лекция", 1),
        PRACTIC("Практика", 2),
        LABA("Лаба", 3);
        private String value;
        private int id;

        TypePara(String value, int id) {
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
