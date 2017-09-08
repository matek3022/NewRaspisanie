package com.example.newraspisanie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newraspisanie.model.Para;

public class PageFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    public static final String RECEIVER_FILTER = "com.example.newraspisanie.filter_receiajgfeasdbg";
    private Para para;
    private int page;
    private Listener listener;
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
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        page = getArguments().getInt(ARG_OBJECT);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(receiver, new IntentFilter(RECEIVER_FILTER + page));
        listener = new Listener() {
            @Override
            public void paraChanged() {
                switch (para.getNumber()) {
                    case 1:
                        ((TextView)getView().findViewById(R.id.time1)).setText(para.getName());
                        break;
                    case 2:
                        ((TextView)getView().findViewById(R.id.time2)).setText(para.getName());
                        break;
                    case 3:
                        ((TextView)getView().findViewById(R.id.time3)).setText(para.getName());
                        break;
                    case 4:
                        ((TextView)getView().findViewById(R.id.time4)).setText(para.getName());
                        break;
                    case 5:
                        ((TextView)getView().findViewById(R.id.time5)).setText(para.getName());
                        break;
                    case 6:
                        ((TextView)getView().findViewById(R.id.time6)).setText(para.getName());
                        break;
                }

            }
        };
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
    }

    interface Listener {
        void paraChanged();
    }
}
