package com.example.newraspisanie;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

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
        manager.clearPara(1,2,4);
        manager.clearPara(1,2,5);
        manager.clearPara(1,2,6);
        //3 день 1 неделя
        manager.setPara(new Para(1, 3, 1, "ЦОС и изображений", null, "608-н.к.", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(1, 3, 2, "Исследование операций и теор. игр", null, "421-14", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(1, 3, 3, "Базы данных", "Додонов", "210-15", Para.TypePara.LABA, "1) 3,7,11,15 | 2) 5,9,13,17"));
        manager.setPara(new Para(1, 3, 4, "Базы данных", "Додонов", "210-15", Para.TypePara.LABA, "1) 3,7,11,15 | 2) 5,9,13,17"));
        manager.clearPara(1,3,5);
        manager.clearPara(1,3,6);
        //4 день 1 неделя
        manager.setPara(new Para(1, 4, 1, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "503-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 4, 2, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "503-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 4, 3, "Компьютерная алгебра", "Веричев", "503-14", Para.TypePara.LEKCIA, null));
        manager.clearPara(1,4,4);
        manager.clearPara(1,4,5);
        manager.clearPara(1,4,6);
        //5 день 1 неделя
        manager.clearPara(1,5,1);
        manager.setPara(new Para(1, 5, 2, "ЦОС и изображений", "доц. Чичева М.А.", "201-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 5, 3, "ЦОС и изображений", "доц. Чичева М.А.", "201-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 5, 4, "Исследование операций и ТИ", "доц. Есипов Б.А.", "502-14", Para.TypePara.LEKCIA, null));
        manager.clearPara(1,5,5);
        manager.clearPara(1,5,6);
        //6 день 1 неделя
        manager.setPara(new Para(1, 6, 1, "Основы управл. деят.", "доц. Голубева Т.В.", "429-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 6, 2, "Философия", "доц. Огнев А.Н.", "429-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(1, 6, 3, "Базы данных", "Додонов", "517-14", Para.TypePara.LEKCIA, null));
        manager.clearPara(1,6,4);
        manager.clearPara(1,6,5);
        manager.clearPara(1,6,6);

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
        manager.clearPara(2,2,4);
        manager.clearPara(2,2,5);
        manager.clearPara(2,2,6);
        //3 день 2 неделя
        manager.clearPara(2,3,1);
        manager.clearPara(2,3,2);
        manager.clearPara(2,3,3);
        manager.setPara(new Para(2, 3, 4, "Компьютерная алгебра", "Веричев", "608-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 3, 5, "Исследование операций и ТИ", "доц. Есипов Б.А.", "430-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 3, 6, "Исследование операций и ТИ", "доц. Есипов Б.А.", "430-14", Para.TypePara.LEKCIA, null));
        //4 день 2 неделя
        manager.setPara(new Para(2, 4, 1, "ЦОС и изображений", "доц. Чичева М.А.", "608-н.к.", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 4, 2, "Базы данных", "Додонов", "517-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 4, 3, "Компьютерная алгебра", "Веричев", "517-14", Para.TypePara.LEKCIA, null));
        manager.clearPara(2,4,4);
        manager.clearPara(2,4,5);
        manager.clearPara(2,4,6);
        //5 день 2 неделя
        manager.clearPara(2,5,1);
        manager.setPara(new Para(2, 5, 2, "Основы управл. деят.", "доц. Голубева Т.В.", "219-14", Para.TypePara.LEKCIA, null));
        manager.setPara(new Para(2, 5, 3, "ЦОС и изображений", null, "201-н.к.", Para.TypePara.PRACTIC, null));
        manager.setPara(new Para(2, 5, 4, "Философия", "доц. Огнев А.Н.", "419-14", Para.TypePara.PRACTIC, null));
        manager.clearPara(2,5,5);
        manager.clearPara(2,5,6);
        //6 день 2 неделя
        manager.clearPara(2,6,1);
        manager.clearPara(2,6,2);
        manager.setPara(new Para(2, 6, 3, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "102,102а-3", Para.TypePara.LABA, "Приходить к 11"));
        manager.setPara(new Para(2, 6, 4, "Безопасность сетей ЭВМ", "Кузнецов М.В.", "102,102а-3", Para.TypePara.LABA, "Приходить к 11"));
        manager.clearPara(2,6,5);
        manager.clearPara(2,6,6);
    }

    public static ViewPager.PageTransformer getTransformer(int index) {
        switch (index) {
            case 1:
                return null;
            case 2:
                return new ZoomOutAndRotatePageTransformer();
            case 3:
                return new ZoomOutPageTransformer();
            case 4:
                return new ZoomOutItemsPageTransformer();
            case 5:
                return new DevilYPageTransformer();
            case 6:
                return new DevilXPageTransformer();
            case 7:
                return new DevilPageTransformer();
            case 8:
                return new DevilItemPageTransformer();
            default:
                return null;
        }
    }

    public static class ZoomOutAndRotatePageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.7f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    view.setRotationY(position * 60);
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

    public static class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.7f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

    public static class ZoomOutItemsPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.7f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            transformElement(view.findViewById(R.id.one), position);
            transformElement(view.findViewById(R.id.two), position);
            transformElement(view.findViewById(R.id.three), position);
            transformElement(view.findViewById(R.id.four), position);
            transformElement(view.findViewById(R.id.five), position);
            transformElement(view.findViewById(R.id.six), position);
        }
        private void transformElement(View view1, float position) {
            if (view1 != null) {
                int pageWidth = view1.getWidth();
                int pageHeight = view1.getHeight();
                if (position < -1) {
                    view1.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view1.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view1.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view1.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view1.setScaleX(scaleFactor);
                    view1.setScaleY(scaleFactor);
                } else {
                    view1.setAlpha(0);
                }
            }
        }
    }

    public static class DevilYPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    view.setRotationY(position * 180);
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

    public static class DevilXPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    view.setRotationX(position * 180);
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

    public static class DevilPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.3f;

        public void transformPage(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    view.setRotationX(position * 180);
                    view.setRotationY(position * 180);
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

    public static class DevilItemPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.3f;
        private static final float MIN_ALPHA = 0.3f;

        public void transformPage(View view, float position) {
            transformElement(view.findViewById(R.id.one), position);
            transformElement(view.findViewById(R.id.two), position);
            transformElement(view.findViewById(R.id.three), position);
            transformElement(view.findViewById(R.id.four), position);
            transformElement(view.findViewById(R.id.five), position);
            transformElement(view.findViewById(R.id.six), position);
        }

        private void transformElement(View view, float position) {
            if (view != null) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();
                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor;
                    scaleFactor = MIN_SCALE + ((1 - MIN_SCALE) / 0.4f) * (0.4f - Math.abs(position));
                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA + ((1 - MIN_ALPHA) / 0.4f) * (0.4f - Math.abs(position)));
                    view.setRotationX(position * 180);
                    view.setRotationY(position * 180);
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(0);
                }
            }
        }
    }

}
