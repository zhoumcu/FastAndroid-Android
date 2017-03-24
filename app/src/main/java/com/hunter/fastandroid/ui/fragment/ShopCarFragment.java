package com.hunter.fastandroid.ui.fragment;

import com.hunter.fastandroid.R;
import com.hunter.fastandroid.base.BaseFragment;
import com.hunter.fastandroid.dao.ProductsCategory;
import com.hunter.fastandroid.dao.ProductsGroup;
import com.hunter.fastandroid.ui.view.interfaces.IProductsCategoryView;
import com.hunter.fastandroid.ui.view.interfaces.IProductsGroupView;

import java.util.List;

/**
 * author：Administrator on 2017/3/24 14:38
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ShopCarFragment extends BaseFragment implements IProductsGroupView, IProductsCategoryView {

    @Override
    public int getLayoutRes() {
        return R.layout.shopcar;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void groupsResult(List<ProductsGroup> groupsResult) {
    }

    @Override
    public void categorysResult(List<ProductsCategory> categorysResult) {

    }
}
