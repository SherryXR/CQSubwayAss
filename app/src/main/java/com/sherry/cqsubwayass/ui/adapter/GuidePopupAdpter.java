package com.sherry.cqsubwayass.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bean.StationBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sherry on 2016/12/20.
 * Function：
 */

public class GuidePopupAdpter extends BaseAdapter {
    private List<StationBean> beanList;
    private LayoutInflater layoutInflater;

    public GuidePopupAdpter(List<StationBean> beanList, LayoutInflater layoutInflater) {
        this.beanList = beanList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = layoutInflater.inflate(R.layout.item_guide_popup, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder.name.setText(beanList.get(position).getName());


        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.item_guide_popup_name_tv)
        TextView name;
        @BindView(R.id.item_guide_popup_data_tv)
        TextView data;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}