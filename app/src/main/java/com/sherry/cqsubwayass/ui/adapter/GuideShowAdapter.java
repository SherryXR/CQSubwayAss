package com.sherry.cqsubwayass.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2016/12/21.
 * Function：
 */

public class GuideShowAdapter extends  RecyclerView.Adapter<GuideShowAdapter.GuideShowViewHolder>{

    private List<Station> stationList =  new ArrayList<>();
    private Context context;

    public GuideShowAdapter(Context context, List<Station> stationList){
        this.stationList = stationList;
        this.context = context;
    }

    @Override
    public GuideShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GuideShowViewHolder holder = new GuideShowViewHolder(LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_guide_show,
                        parent,
                        false));
        return holder;
    }

    @Override
    public void onBindViewHolder(GuideShowViewHolder holder, int position) {
        holder.num.setText(position+1+"");
        holder.name.setText(stationList.get(position).getName());
        if (stationList.get(position).isHuan()){
            holder.img.setImageResource(R.mipmap.ic_lingdang_yellow);
        }else {
            holder.tips.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    class GuideShowViewHolder extends RecyclerView.ViewHolder{

        private Button num;
        private TextView name;
        private TextView tips;
        private ImageView img;

        public GuideShowViewHolder(View itemView) {
            super(itemView);
            num = (Button) itemView.findViewById(R.id.item_guide_show_num);
            name = (TextView) itemView.findViewById(R.id.item_guide_show_name);
            tips = (TextView) itemView.findViewById(R.id.item_guide_show_tips);
            img = (ImageView) itemView.findViewById(R.id.item_guide_show_lingdang);
        }
    }
}
