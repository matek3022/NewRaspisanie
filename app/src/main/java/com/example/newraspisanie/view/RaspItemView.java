package com.example.newraspisanie.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newraspisanie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matek on 07.09.2017.
 */

public class RaspItemView extends LinearLayout {

    @BindView(R.id.time)
    TextView time;

    public RaspItemView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init();
        }
    }

    public RaspItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init();
        }
    }

    public RaspItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RaspItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            init();
        }
    }

    private void init() {
        removeAllViews();
        View view = View.inflate(getContext(), R.layout.layout_rasp_item_view, (ViewGroup) getParent());
        ButterKnife.bind(this, view);
        addView(view);
    }
}
