package com.sherry.cqsubwayass.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.presenter.MainActivityPresenter;
import com.sherry.cqsubwayass.ui.adapter.MainViewPagerAdapter;
import com.sherry.cqsubwayass.ui.view.IMainActivityView;
import com.sherry.cqsubwayass.utils.BottomNavigationViewHelper;
import com.sherry.cqsubwayass.widget.NoScrollViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivty implements IMainActivityView {

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewPager;
    private MenuItem menuItem;

    MainViewPagerAdapter adapter;
    private MainActivityPresenter mainActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityPresenter = new MainActivityPresenter(this,this);
        /**
         * ---------------------------滑动页面时候取消动画----------------------------
         * BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
         * ------------------------------------------------------------------------
         */
        viewPager.setScanScroll(false);
        viewPager.setOffscreenPageLimit(3);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_go_out:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_station:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_find:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_mine:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
/**
 * -------------------------禁止滑动----------------------------------------------------------------------
 *
 *       viewPager.setOnTouchListener(new View.OnTouchListener() {
 *           @Override
 *           public boolean onTouch(View v, MotionEvent event) {
 *               return true;
 *          }
 *       });
 *-----------------------------------------------------------------------------------------------------------
 * */
        mainActivityPresenter.loadFragment();
    }

    @Override
    public void setupViewPager(List<Fragment> lists) {
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());

        for (int i=0;i<lists.size();i++){
            adapter.addFragment(lists.get(i));
        }
        viewPager.setAdapter(adapter);
    }
}
