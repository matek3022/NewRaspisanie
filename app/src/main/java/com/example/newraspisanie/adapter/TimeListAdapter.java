package com.example.newraspisanie.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newraspisanie.GuiUtils;
import com.example.newraspisanie.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matek on 01.10.2017.
 */

public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.ViewHolder> {

    private List<String> list;

    public TimeListAdapter (List<String> list) {
        this.list = list;
    }
    @Override
    public TimeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TimeListAdapter.ViewHolder holder, final int position) {
        holder.text.setText(list.get(position));
        holder.index.setText(String.valueOf(position + 1));
        holder.text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list.remove(position);
                list.add(position, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.text.isFocused()) GuiUtils.hideKeyboard(holder.text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<String> getList() {
        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        EditText text;
        @BindView(R.id.index)
        TextView index;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
