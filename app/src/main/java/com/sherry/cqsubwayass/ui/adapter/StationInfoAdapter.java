package com.sherry.cqsubwayass.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.StationBean;

import java.util.List;

/**
 * Created by Sherry on 2018/4/14.
 */

public class StationInfoAdapter extends RecyclerView.Adapter<StationInfoAdapter.StationInfoViewHolder>{

    private StationBean stationBean;

    public StationInfoAdapter(StationBean bean){
        this.stationBean = bean;
    }

    @Override
    public StationInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StationInfoAdapter.StationInfoViewHolder stationInfoViewHolder = new StationInfoAdapter.StationInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station_info, parent, false));

        return stationInfoViewHolder;
    }

    @Override
    public void onBindViewHolder(StationInfoViewHolder holder, int position) {

            holder.item_station_info_exit_name.setText(stationBean.getExitInfo().getExit_number().get(position));
            holder.item_station_info_exit_to.setText(stationBean.getExitInfo().getExitInfoLists().get(position));

    }

    @Override
    public int getItemCount() {
        return stationBean.getExitInfo().getExitInfoLists().size();
    }

    class StationInfoViewHolder extends RecyclerView.ViewHolder{

        private TextView item_station_info_exit_to;
        private TextView item_station_info_exit_name;

        public StationInfoViewHolder(View itemView) {
            super(itemView);
            item_station_info_exit_to = itemView.findViewById(R.id.item_station_exit_to);
            item_station_info_exit_name = itemView.findViewById(R.id.item_station_exit_name);
        }
    }
}
