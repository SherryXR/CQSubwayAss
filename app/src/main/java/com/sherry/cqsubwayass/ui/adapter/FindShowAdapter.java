package com.sherry.cqsubwayass.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherry on 2018/4/16.
 */

public class FindShowAdapter extends RecyclerView.Adapter<FindShowAdapter.FindShowViewHolder>{

    private List<FindBean> findBeans = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public FindShowAdapter(List<FindBean> findBeans){
        this.findBeans = findBeans;
    }

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.onItemClickListener = mOnItemClickLitener;
    }

    @Override
    public FindShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FindShowAdapter.FindShowViewHolder findShowViewHolder = new FindShowAdapter.FindShowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find_show, parent, false));
        return findShowViewHolder;
    }

    @Override
    public void onBindViewHolder(final FindShowViewHolder holder, final int position) {
        holder.title.setText(findBeans.get(position).getTitle());
        holder.message.setText(findBeans.get(position).getMessage());
        holder.imageView.setImageResource(findBeans.get(position).getImageLists().get(0));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return findBeans.size();
    }

    class FindShowViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView message;
        private ImageView imageView;

        public FindShowViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_find_show_title);
            message = itemView.findViewById(R.id.item_find_show_message);
            imageView = itemView.findViewById(R.id.item_find_show_image);

        }
    }
}
