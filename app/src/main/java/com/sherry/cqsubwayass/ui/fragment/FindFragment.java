package com.sherry.cqsubwayass.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.presenter.FindFragmentPresenter;
import com.sherry.cqsubwayass.ui.view.IFindFragmetView;

/**
 * Created by Sherry on 2018/4/8.
 */

public class FindFragment extends Fragment implements IFindFragmetView{

    private RecyclerView rv;
    private FindFragmentPresenter findFragmentPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,null);
        rv = view.findViewById(R.id.find_rv);
        findFragmentPresenter = new FindFragmentPresenter(this,getActivity());
        findFragmentPresenter.showData(rv);
        return view;
    }

    @Override
    public void setRv() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
        //通过布局管理器控制条目排列的顺序  true:反向显示 false:正向显示
        staggeredGridLayoutManager.setReverseLayout(false);
        rv.setLayoutManager(staggeredGridLayoutManager);
    }
}
