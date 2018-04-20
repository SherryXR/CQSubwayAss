package com.sherry.cqsubwayass.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.presenter.StationFragmentPresenter;
import com.sherry.cqsubwayass.ui.activity.SubwayLineActivity;
import com.sherry.cqsubwayass.ui.adapter.StationRvAdapter;
import com.sherry.cqsubwayass.ui.view.IStationFragmentView;

import java.util.zip.Inflater;

/**
 * Created by Kevin Liu on 2018/4/8.
 */

public class StationFragment extends Fragment implements IStationFragmentView{

    private RecyclerView station_rv;
    private StationFragmentPresenter stationFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_station,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        station_rv =view.findViewById(R.id.station_rv);
        stationFragmentPresenter = new StationFragmentPresenter(getActivity(),this);
        stationFragmentPresenter.loadSubway(station_rv);

    }

    @Override
    public void showRv() {
        station_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void toSubwayLine(StationRvAdapter adapter) {
        adapter.setOnItemClickLitener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =  new Intent(getActivity(), SubwayLineActivity.class);
                switch (position){
                    case 0:
                        intent.putExtra("subwayLine",0);
                        break;
                    case 1:
                        intent.putExtra("subwayLine",1);
                        break;
                    case 2:
                        intent.putExtra("subwayLine",2);
                        break;
                    case 3:
                        intent.putExtra("subwayLine",3);
                        break;
                    case 4:
                        intent.putExtra("subwayLine",4);
                        break;
                    case 5:
                        intent.putExtra("subwayLine",5);
                        break;
                    case 6:
                        intent.putExtra("subwayLine",6);
                        break;
                    case 7:
                        intent.putExtra("subwayLine",7);
                        break;
                }
                getActivity().startActivity(intent);
            }
        });
    }
}
