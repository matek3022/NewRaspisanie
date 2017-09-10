package com.example.newraspisanie;

import android.app.AlertDialog;
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
    public static final String ARG_CURR_WEEK = "curr_week";
    public static final String PARA_CHANGE_RECEIVER_FILTER = "com.example.newraspisanie.parachange_filter_receiajgfeasdbg";
    public static final String WEEK_CHANGE_RECEIVER_FILTER = "com.example.newraspisanie.weekchange_filter_receiajgfeasdbg";
    private Para para;
    private int page;
    private int week;
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
    private BroadcastReceiver paraChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            para = (Para) intent.getSerializableExtra(ARG_OBJECT);
            if (listener != null) {
                listener.paraChanged();
            }
        }
    };

    private BroadcastReceiver weekChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            week = intent.getIntExtra(ARG_OBJECT, week);
            refreshUI();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.wtf("getItem", "" + 100);
        final View rootView = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.bind(this, rootView);
        page = getArguments().getInt(ARG_OBJECT);
        week = getArguments().getInt(ARG_CURR_WEEK);
        preferenceManager = PreferenceManager.getInstance(getContext());
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(weekChangeReceiver, new IntentFilter(WEEK_CHANGE_RECEIVER_FILTER));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        if (para == null) {
            refreshUI();
        }
    }

    private void refreshUI() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(paraChangeReceiver);
        /**
         * перерегистриуем ресивер, когда меняется неделя
         */
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(paraChangeReceiver, new IntentFilter(PARA_CHANGE_RECEIVER_FILTER + page + "_" + week));
        one.clearView();
        two.clearView();
        three.clearView();
        four.clearView();
        five.clearView();
        six.clearView();
        for (int i = 0; i < 6; i++) {
            para = preferenceManager.getPara(week, page, i + 1);
            listener.paraChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(paraChangeReceiver);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(weekChangeReceiver);
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
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = one.getPara();
                        if (one.getPara() == null) {
                            currPara = new Para(week, page, 1);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 1);
                        one.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = two.getPara();
                        if (two.getPara() == null) {
                            currPara = new Para(week, page, 2);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 2);
                        two.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = three.getPara();
                        if (three.getPara() == null) {
                            currPara = new Para(week, page, 3);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 3);
                        three.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = four.getPara();
                        if (four.getPara() == null) {
                            currPara = new Para(week, page, 4);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 4);
                        four.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = five.getPara();
                        if (five.getPara() == null) {
                            currPara = new Para(week, page, 5);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 5);
                        five.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_action_para_pressed, null);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                view.findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Para currPara = six.getPara();
                        if (six.getPara() == null) {
                            currPara = new Para(week, page, 6);
                        }
                        ((SwipeViewActivity) getActivity()).showAddDialog(currPara);
                        dialog.dismiss();
                    }
                });
                view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preferenceManager.clearPara(week, page, 6);
                        six.clearView();
                        showDeleteMessage();
                        dialog.dismiss();
                    }
                });
                dialog.show();

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
