/*
 * Copyright (C) 2018 Milan Herrera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mhv.simpleactionmode;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private ArrayList<Model> mDataSet;
    private ArrayList<Integer> mSelectedItemPositions;

    SampleAdapter(Context context, ArrayList<Model> dataSet) {
        mContext = context;
        mDataSet = dataSet;
        mSelectedItemPositions = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SampleViewHolder demoHolder = (SampleViewHolder) holder;
        demoHolder.getTitleView().setText(mDataSet.get(position).getMessage());
        demoHolder.getSubtitleView().setText(Utils.formatDate(mDataSet.get(position).getDate()));

        if (mSelectedItemPositions.contains(position)) {
            demoHolder.itemView.setBackgroundDrawable(
                    new ColorDrawable(mContext.getResources().getColor(R.color.colorAccent)));
        } else {
            demoHolder.itemView.setBackgroundDrawable(
                    Utils.getSelectableBackgroundDrawable(mContext));
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    void removeItem(int position) {
        mDataSet.remove(position);
        notifyDataSetChanged();
    }

    Model getItem(int position) {
        return mDataSet.get(position);
    }

    void toggleSelection(int position) {
        if (mSelectedItemPositions.contains(position)) {
            mSelectedItemPositions.remove(mSelectedItemPositions.indexOf(position));
        } else {
            mSelectedItemPositions.add(position);
        }
        notifyDataSetChanged();
    }

    void clearAllSelections() {
        mSelectedItemPositions.clear();
        notifyDataSetChanged();
    }

    int getSelectedCount() {
        return mSelectedItemPositions.size();
    }

    ArrayList<Integer> getSelectedPositions() {
        return mSelectedItemPositions;
    }
}