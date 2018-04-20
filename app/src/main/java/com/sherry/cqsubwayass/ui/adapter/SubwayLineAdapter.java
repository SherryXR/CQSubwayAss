package com.sherry.cqsubwayass.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/14.
 */

public class SubwayLineAdapter extends RecyclerView.Adapter<SubwayLineAdapter.SubwayLineViewHolder>{

    private OnItemClickListener onItemClickListener;
    private List<StationBean> stationBeanList = new ArrayList<>();
    private int num,subwayColor;
    private Context context;

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.onItemClickListener = mOnItemClickLitener;
    }
    public SubwayLineAdapter(List<StationBean> lists,int num,Context context){
        this.num = num;
        stationBeanList = lists;
        this.context =context;
    }

    @Override
    public SubwayLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SubwayLineAdapter.SubwayLineViewHolder subwayLineViewHolder = new SubwayLineAdapter.SubwayLineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subway_line, parent, false));

        return subwayLineViewHolder;
    }

    @Override
    public void onBindViewHolder(final SubwayLineViewHolder holder, final int position) {
        holder.subway_line_name.setText(stationBeanList.get(position).getName());
        switch (num){
            case 0:
                subwayColor =context.getResources().getColor(R.color.subway_one);
                break;
            case 1:
                subwayColor =context.getResources().getColor(R.color.subway_two);
                break;
            case 2:
                subwayColor =context.getResources().getColor(R.color.subway_three);
                break;
            case 3:
                subwayColor =context.getResources().getColor(R.color.subway_five);
                break;
            case 4:
                subwayColor =context.getResources().getColor(R.color.subway_six);
                break;
            case 5:
                subwayColor =context.getResources().getColor(R.color.subway_ten);
                break;
            case 6:
                subwayColor =context.getResources().getColor(R.color.subway_three);
                break;
            case 7:
                subwayColor =context.getResources().getColor(R.color.subway_six);
                break;
        }
        holder.subway_line_name.setTextColor(subwayColor);
        holder.subway_line_point.setColorFilter(subwayColor);
        holder.subway_line_view.setBackgroundColor(subwayColor);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stationBeanList.size();
    }

    class SubwayLineViewHolder extends RecyclerView.ViewHolder{

        private ImageView subway_line_point;
        private TextView subway_line_name;
        private View subway_line_view;

        public SubwayLineViewHolder(View itemView) {
            super(itemView);
            subway_line_point = itemView.findViewById(R.id.item_subway_point);
            subway_line_name = itemView.findViewById(R.id.item_subway_name);
            subway_line_view =itemView.findViewById(R.id.item_subway_view);
        }
    }
}
