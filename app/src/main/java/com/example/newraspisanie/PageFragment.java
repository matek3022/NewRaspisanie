package com.example.newraspisanie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newraspisanie.manager.PreferenceManager;
import com.example.newraspisanie.model.Para;
import com.example.newraspisanie.view.RaspItemView;

import butterknife.BindView;
import butterknife.ButterKnife;

//fragment (small activity) class
public class PageFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    public static final String RECEIVER_FILTER = "com.example.newraspisanie.filter_receiajgfeasdbg";
    private Para para;
    private int page;
    private PreferenceManager preferenceManager;
    private Listener listener;
    @BindView(R.id.one)
    RaspItemView one;
    @BindView(R.id.two)
    RaspItemView two;
    @BindView(R.id.three)
    RaspItemView three;
    @BindView(R.id.four)
    RaspItemView four;
    @BindView(R.id.five)
    RaspItemView five;
    @BindView(R.id.six)
    RaspItemView six;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            para = (Para) intent.getSerializableExtra(ARG_OBJECT);
            if (listener != null) {
                listener.paraChanged();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.wtf("getItem", "" + 100);
        final View rootView = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.bind(this, rootView);
        page = getArguments().getInt(ARG_OBJECT);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(receiver, new IntentFilter(RECEIVER_FILTER + page + "_" + 1));
        preferenceManager = PreferenceManager.getInstance(getContext());
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        if (para == null) {
            for (int i = 0; i < 6; i++) {
                para = preferenceManager.getPara(1, page, i + 1);
                listener.paraChanged();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
    }

    private void initListeners() {
        listener = new Listener() {
            @Override
            public void paraChanged() {
                if (para != null) {
                    switch (para.getNumber()) {
                        case 1:
                            one.setPara(para);
                            break;
                        case 2:
                            two.setPara(para);
                            break;
                        case 3:
                            three.setPara(para);
                            break;
                        case 4:
                            four.setPara(para);
                            break;
                        case 5:
                            five.setPara(para);
                            break;
                        case 6:
                            six.setPara(para);
                            break;
                    }
                }

            }
        };

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = one.getPara();
                if (one.getPara() == null) {
                    currPara = new Para(1, page, 1);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = two.getPara();
                if (two.getPara() == null) {
                    currPara = new Para(1, page, 2);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = three.getPara();
                if (three.getPara() == null) {
                    currPara = new Para(1, page, 3);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = four.getPara();
                if (four.getPara() == null) {
                    currPara = new Para(1, page, 4);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = five.getPara();
                if (five.getPara() == null) {
                    currPara = new Para(1, page, 5);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Para currPara = six.getPara();
                if (six.getPara() == null) {
                    currPara = new Para(1, page, 6);
                }
                ((SwipeViewActivity)getActivity()).showAddDialog(currPara);
            }
        });

        //слушатели долгого нажатия на элемент - удаляет запись элемента
        one.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 1);
                one.clearView();
                showDeleteMessage();
                return false;
            }
        });
        two.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 2);
                two.clearView();
                showDeleteMessage();
                return false;
            }
        });
        three.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 3);
                three.clearView();
                showDeleteMessage();
                return false;
            }
        });
        four.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 4);
                four.clearView();
                showDeleteMessage();
                return false;
            }
        });
        five.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 5);
                five.clearView();
                showDeleteMessage();
                return false;
            }
        });
        six.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                preferenceManager.clearPara(1, page, 6);
                six.clearView();
                showDeleteMessage();
                return false;
            }
        });
    }

    private void showDeleteMessage() {
        Toast.makeText(getContext(), "Вы удалили пару", Toast.LENGTH_SHORT).show();
    }

    interface Listener {
        void paraChanged();
    }
}
