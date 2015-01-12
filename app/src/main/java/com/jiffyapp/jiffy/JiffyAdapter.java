package com.jiffyapp.jiffy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ehis on 1/10/15.
 * Jiffy Adapter (Custom Adapter for Recycler View)
 */
public class JiffyAdapter extends RecyclerView.Adapter<JiffyAdapter.ViewHolder> {

    private ArrayList<String> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.info_text);
        }
    }

    // constructor
    public JiffyAdapter(ArrayList<String> myDataSet) {
        mDataSet = myDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // get elements from your data Set at that position
        holder.mTextView.setText(mDataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
