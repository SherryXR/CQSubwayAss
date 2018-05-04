package com.sherry.cqsubwayass.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.SubwayInfo;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherry on 2018/4/13.
 */

public class StationRvAdapter extends RecyclerView.Adapter<StationRvAdapter.StationRvViewHolder> {

    private List<SubwayInfo> lists = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public StationRvAdapter(List<SubwayInfo> lists) {
        this.lists =lists;
    }

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.onItemClickListener = mOnItemClickLitener;
    }

    @Override
    public StationRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StationRvViewHolder stationRvViewHolder = new StationRvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false));
        return stationRvViewHolder;
    }

    @Override
    public void onBindViewHolder(final StationRvViewHolder holder, final int position) {
        holder.subway_name.setText(lists.get(position).getSubway_name());
        holder.subway_bg.setBackgroundColor(lists.get(position).getSubway_color());
        holder.subway_name.setTextColor(lists.get(position).getSubway_color());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                onItemClickListener.onItemClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class StationRvViewHolder extends RecyclerView.ViewHolder{

        private View subway_bg;
        private TextView subway_name;

        public StationRvViewHolder(View itemView) {
            super(itemView);
            subway_bg = itemView.findViewById(R.id.item_station_bg);
            subway_name = itemView.findViewById(R.id.item_station_subway_name);
        }
    }
}
