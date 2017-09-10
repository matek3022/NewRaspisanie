package com.example.newraspisanie;

import android.content.Context;

import com.example.newraspisanie.manager.PreferenceManager;
import com.example.newraspisanie.model.Para;

/**
 * Created by matek on 10.09.2017.
 */

public class Utils {
    public static void set6412List(Context context) {
        PreferenceManager manager = PreferenceManager.getInstance(context);
        //1 день 1 неделя
        manager.setPara(new Para(1, 1, 1, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 1, 2, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 1, 3, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 1, 4, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 1, 5, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 1, 6, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        //2 день 1 неделя
        manager.setPara(new Para(1, 2, 1, "Надежность и качество ПО", "проф. Мостовой Я.А.", "608-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 2, 2, "Компьютерная алгебра", "Додонова", "201-н.к.", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(1, 2, 3, "Надежность и качество ПО", null, "608-н.к.", Para.TypePara.PRACTIC, null));
        //3 день 1 неделя
        manager.setPara(new Para(1, 3, 1, "ЦОС и изображений", null, "608-н.к.", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(1, 3, 2, "Исследование операций и теор. игр", null, "421-14", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(1, 3, 3, "Базы данных", "Додонов", "210-15", Para.TypePara.LABA, "1) 3,7,11,15 | 2) 5,9,13,17"));
        manager.setPara(new Para(1, 3, 4, "Базы данных", "Додонов", "210-15", Para.TypePara.LABA, "1) 3,7,11,15 | 2) 5,9,13,17"));
        //4 день 1 неделя
        manager.setPara(new Para(1, 4, 1, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "503-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 4, 2, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "503-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 4, 3, "Компьютерная алгебра", "Веричев", "503-14", Para.TypePara.LEKCIA, null));
        //5 день 1 неделя
        manager.setPara(new Para(1, 5, 2, "ЦОС и изображений", "доц. Чичева М.А.", "201-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 5, 3, "ЦОС и изображений", "доц. Чичева М.А.", "201-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 5, 4, "Исследование операций и ТИ", "доц. Есипов Б.А.", "502-14", Para.TypePara.LEKCIA, null));
        //6 день 1 неделя
        manager.setPara(new Para(1, 6, 1, "Основы управл. деят.", "доц. Голубева Т.В.", "429-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 6, 2, "Философия", "доц. Огнев А.Н.", "429-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 6, 3, "Базы данных", "Додонов", "517-14", Para.TypePara.LEKCIA, null));

        //1 день 2 неделя
        manager.setPara(new Para(2, 1, 1, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 1, 2, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 1, 3, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 1, 4, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 1, 5, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 1, 6, "Военная кафедра", null, null, Para.TypePara.LEKCIA, null));
        //2 день 2 неделя
        manager.setPara(new Para(2, 2, 1, "Надежность и кач. ПО | Базы данных", "1) 2,6,10,14 | 4,8,12,16", "102-3; 519-14", Para.TypePara.LABA, "2) 4,8,12,16 | 2,6,10,14"));
        manager.setPara(new Para(2, 2, 2, "Надежность и кач. ПО | Базы данных", "1) 2,6,10,14 | 4,8,12,16", "102-3; 519-14", Para.TypePara.LABA, "2) 4,8,12,16 | 2,6,10,14"));
        manager.setPara(new Para(2, 2, 3, "Надежность и качество ПО", "проф. Мостовой Я.А.", "503-3а", Para.TypePara.LEKCIA, null));
        //3 день 2 неделя
        manager.setPara(new Para(2, 3, 4, "Компьютерная алгебра", "Веричев", "608-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 3, 5, "Исследование операций и ТИ", "доц. Есипов Б.А.", "430-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 3, 6, "Исследование операций и ТИ", "доц. Есипов Б.А.", "430-14", Para.TypePara.LEKCIA, null));
        //4 день 2 неделя
        manager.setPara(new Para(2, 4, 1, "ЦОС и изображений", "доц. Чичева М.А.", "608-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 4, 2, "Базы данных", "Додонов", "517-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 4, 3, "Компьютерная алгебра", "Веричев", "517-14", Para.TypePara.LEKCIA, null));
        //5 день 2 неделя
        manager.setPara(new Para(2, 5, 2, "Основы управл. деят.", "доц. Голубева Т.В.", "219-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 5, 3, "ЦОС и изображений", null, "201-н.к.", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(2, 5, 4, "Философия", "доц. Огнев А.Н.", "419-14", Para.TypePara.PRACTIC, null));
        //6 день 2 неделя
        manager.setPara(new Para(2, 6, 3, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "102,102а-3", Para.TypePara.LABA, "Приходить к 11"));
        manager.setPara(new Para(2, 6, 4, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "102,102а-3", Para.TypePara.LABA, "Приходить к 11"));
    }
}
