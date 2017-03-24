package com.hunter.fastandroid.ui.activity;

import android.view.View;

import com.hunter.fastandroid.R;
import com.hunter.fastandroid.base.BaseActivity;
import com.hunter.fastandroid.ui.custom.TitleBar;
import com.hunter.fastandroid.ui.fragment.ActivityFragment;
import com.hunter.fastandroid.ui.fragment.CategoryFragment;
import com.hunter.fastandroid.ui.fragment.HomeFragment;
import com.hunter.fastandroid.ui.fragment.ShopCarNotNoneFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.title_bar)
    TitleBar titleBar;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        titleBar.setTitle("DEMO");
        addFragment(R.id.contains,new HomeFragment());
    }

    @Override
    public void initPresenter() {

    }

    @OnClick({R.id.btn_item1, R.id.btn_item2, R.id.btn_item3, R.id.btn_item4, R.id.btn_item5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_item1:
                replaceFragment(R.id.contains,new HomeFragment());
                break;
            case R.id.btn_item2:
                replaceFragment(R.id.contains,new CategoryFragment());
                break;
            case R.id.btn_item3:
                replaceFragment(R.id.contains,new ActivityFragment());
                break;
            case R.id.btn_item4:
                replaceFragment(R.id.contains,new ShopCarNotNoneFragment());
                break;
            case R.id.btn_item5:
                replaceFragment(R.id.contains,new HomeFragment());
                break;
        }
    }

}
