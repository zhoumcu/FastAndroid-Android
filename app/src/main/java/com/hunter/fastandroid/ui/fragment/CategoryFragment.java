package com.hunter.fastandroid.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.hunter.fastandroid.R;
import com.hunter.fastandroid.adapter.CategoryGroupAdapter;
import com.hunter.fastandroid.adapter.CategorysAdapter;
import com.hunter.fastandroid.base.BaseFragment;
import com.hunter.fastandroid.dao.ProductsCategory;
import com.hunter.fastandroid.dao.ProductsGroup;
import com.hunter.fastandroid.presenter.impl.ProductsPresenterImpl;
import com.hunter.fastandroid.presenter.interfaces.IProductsPresenter;
import com.hunter.fastandroid.ui.activity.products.ProductsActivity;
import com.hunter.fastandroid.ui.view.interfaces.IProductsCategoryView;
import com.hunter.fastandroid.ui.view.interfaces.IProductsGroupView;

import java.util.List;

import butterknife.Bind;

/**
 * author：Administrator on 2017/3/24 14:38
 * company: xxxx
 * email：1032324589@qq.com
 */

public class CategoryFragment extends BaseFragment implements IProductsGroupView, IProductsCategoryView {

    @Bind(R.id.listView1)
    ListView lvCategoryGroup;
    @Bind(R.id.gridView1)
    GridView gvCategorys;

    CategoryGroupAdapter categoryGroupAdapter;
    CategorysAdapter categorysAdapter;

    IProductsPresenter productsPresenter;

    @Override
    public int getLayoutRes() {
        return R.layout.frg_category;
    }

    @Override
    public void initView() {
        // 初始化产品分组适配器
        categoryGroupAdapter = new CategoryGroupAdapter(getActivity());
        lvCategoryGroup.setAdapter(categoryGroupAdapter);
        // 设置产品分组点击监听
        lvCategoryGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 清空当前分类数据
                categorysAdapter.clear();
                categorysAdapter.notifyDataSetChanged();

                // 改变当前item选中状态
                ProductsGroup itemData = categoryGroupAdapter.getItemData(position);
                categoryGroupAdapter.checkItem(position);
                categoryGroupAdapter.notifyDataSetChanged();

                // 获取该分组对应的分类数据
                productsPresenter.productsCategorys(itemData.getId().intValue(), CategoryFragment.this);
            }
        });

        // 初始化产品分类适配器
        categorysAdapter = new CategorysAdapter(getContext());
        gvCategorys.setAdapter(categorysAdapter);
        gvCategorys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductsCategory itemData = categorysAdapter.getItemData(position);
                Intent intent = new Intent(getContext(), ProductsActivity.class);
                intent.putExtra("categoryId", itemData.getId());
                startActivity(intent);
            }
        });

        // 开始获取所有产品分组数据
        productsPresenter.productsGroups(this);
    }

    @Override
    public void initPresenter() {
        productsPresenter = new ProductsPresenterImpl();
    }

    @Override
    public void groupsResult(List<ProductsGroup> groupsResult) {
        // 更新产品分组数据
        categoryGroupAdapter.setData(groupsResult);
        categoryGroupAdapter.notifyDataSetChanged();
    }

    @Override
    public void categorysResult(List<ProductsCategory> categorysResult) {
        // 更新产品分类数据
        categorysAdapter.setData(categorysResult);
        categorysAdapter.notifyDataSetChanged();
    }
}
