package com.example.newraspisanie;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by matek on 01.10.2017.
 */

public class GuiUtils {
    /**
     * Скрываем клавиатуру
     *
     * @param v любая {@link View}
     */
    public static void hideKeyboard(View v) {
        if (v != null && v.getContext() != null) {
            if (!v.isFocused()) {
                v.requestFocus();
            }
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static void showForcedKeyboard(View v) {
        InputMethodManager inputMananger = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMananger.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static void showKeyboard(View v) {
        if (v != null && v.getContext() != null) {
            if (!v.isFocused()) {
                v.requestFocus();
            }
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(v, 0);
        }
    }

    public static void displayOkMessage(Context context, int message, DialogInterface.OnClickListener okListener) {
        displayOkMessage(context, context.getString(message), okListener);
    }

    public static void displayOkMessage(Context context, int message) {
        displayOkMessage(context, context.getString(message), null);
    }

    public static void displayOkMessage(Context context, String message, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("Ок", okListener);
        builder.show();
    }

    public static void displayYesAndNotMessage(Context context, String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener notListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("Да", okListener);
        builder.setNegativeButton("Нет", notListener);
        builder.show();
    }
}
