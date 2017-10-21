package com.example.newraspisanie.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.transition.Explode;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newraspisanie.R;
import com.example.newraspisanie.manager.PreferenceManager;
import com.example.newraspisanie.model.Para;
import com.example.newraspisanie.transition.RotateTransition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matek on 07.09.2017.
 */

public class RaspItemView extends LinearLayout {

    private static final String one = "8:00-9:35";
    private static final String two = "9:45-11:20";
    private static final String three = "11:30-13:05";
    private static final String four = "13:30-15:05";
    private static final String five = "15:15-16:50";
    private static final String six = "17:00-18:35";

    @BindView(R.id.time)
    TextView time;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.prepod_name)
    TextView prepodName;

    @BindView(R.id.auditory)
    TextView auditory;

    @BindView(R.id.type)
    TextView type;

    @BindView(R.id.extended)
    TextView extended;

    @BindView(R.id.card_parent)
    CardView cardView;

    @BindView(R.id.root)
    ViewGroup root;

    @BindView(R.id.infoButtonContainer)
    FrameLayout infoButtonContainer;
    @BindView(R.id.infoButton)
    ImageView infoButton;
    @BindView(R.id.info)
    TextView info;

    private Para para;
    private boolean opened;

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

    public Para getPara() {
        return para;
    }

    public void setPara(Para para) {
        clearView();
        this.para = para;
        if (para != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Explode explode = new Explode();
            }
            boolean customTime = PreferenceManager.getInstance(getContext()).isCustomTime();
            List<String> customTimeList = PreferenceManager.getInstance(getContext()).getTime();
            switch (para.getNumber()) {
                case 1:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(0) : one);
                    break;
                case 2:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(1) : two);
                    break;
                case 3:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(2) : three);
                    break;
                case 4:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(3) : four);
                    break;
                case 5:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(4) : five);
                    break;
                case 6:
                    time.setText(!TextUtils.isEmpty(para.getTime()) ? para.getTime() : customTime ? customTimeList.get(5) : six);
                    break;
            }
            type.setText(para.getTypePara() != null ? para.getTypePara().toString() : "Другое");
            if (para.getTypePara() != null) {
                switch (para.getTypePara()) {
                    case LABA:
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.labaColor));
                        break;
                    case PRACTIC:
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.practicColor));
                        break;
                    case LEKCIA:
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.lekciaColor));
                        break;
                    default:
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.otherColor));
                }
            } else {
                cardView.setCardBackgroundColor(getResources().getColor(R.color.otherColor));
            }
            name.setText(para.getName());
            auditory.setText(para.getAuditory());
            prepodName.setText(para.getNamePrepod());
            extended.setText(para.getExtended());
            if (!TextUtils.isEmpty(para.getInfo())) {
                infoButtonContainer.setVisibility(VISIBLE);
                info.setText(para.getInfo());
            } else {
                infoButtonContainer.setVisibility(GONE);
                info.setText("");
            }
            infoButton.setRotation(0);
            info.setVisibility(GONE);
            opened = false;
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        cardView.setOnClickListener(l);
    }

    public void clearView() {
        para = null;
        time.setText("");
        type.setText("");
        cardView.setCardBackgroundColor(getResources().getColor(R.color.nothingColor));
        name.setText("");
        auditory.setText("");
        prepodName.setText("");
        extended.setText("");
        info.setText("");
        infoButtonContainer.setVisibility(GONE);
        infoButton.setRotation(0);
        info.setVisibility(GONE);
        opened = false;
    }


    private void processInfo() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(500);
        Fade fade = new Fade();
        fade.setDuration(500);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(500);
        if (opened) {
            TransitionManager.beginDelayedTransition((ViewGroup) cardView.getRootView(), changeBounds);
            TransitionManager.beginDelayedTransition(root, fade);
            info.setVisibility(GONE);
            TransitionManager.beginDelayedTransition(infoButtonContainer, rotateTransition);
            infoButton.setRotation(0);
            opened = false;
        } else {
            TransitionManager.beginDelayedTransition((ViewGroup) cardView.getRootView(), changeBounds);
            TransitionManager.beginDelayedTransition(root, fade);
            info.setVisibility(VISIBLE);
            TransitionManager.beginDelayedTransition(infoButtonContainer, rotateTransition);
            infoButton.setRotation(180);
            opened = true;
        }
    }

    private void init() {
        removeAllViews();
        View view = View.inflate(getContext(), R.layout.layout_rasp_item_view, (ViewGroup) getParent());
        ButterKnife.bind(this, view);
        infoButtonContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                processInfo();
            }
        });
        addView(view);
    }
}
