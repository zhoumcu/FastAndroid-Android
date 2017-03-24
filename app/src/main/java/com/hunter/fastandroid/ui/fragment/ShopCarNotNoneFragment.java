package com.hunter.fastandroid.ui.fragment;

import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hunter.fastandroid.R;
import com.hunter.fastandroid.adapter.ShopCarExpandableListViewAdapter;
import com.hunter.fastandroid.base.BaseFragment;
import com.hunter.fastandroid.dao.ProductsCategory;
import com.hunter.fastandroid.dao.ProductsGroup;
import com.hunter.fastandroid.ui.view.interfaces.IProductsCategoryView;
import com.hunter.fastandroid.ui.view.interfaces.IProductsGroupView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * author：Administrator on 2017/3/24 14:38
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ShopCarNotNoneFragment extends BaseFragment implements IProductsGroupView, IProductsCategoryView {

    @Bind(R.id.checkBox2)
    CheckBox checkBox2;
    @Bind(R.id.txtTotalPrice)
    TextView txtTotalPrice;
    @Bind(R.id.btnSubmitOrder)
    ImageView btnSubmitOrder;
    @Bind(R.id.txtSubmitOrder)
    TextView txtSubmitOrder;
    @Bind(R.id.submitOrderLayout)
    RelativeLayout submitOrderLayout;
    @Bind(R.id.linSubmitLayout)
    LinearLayout linSubmitLayout;
    @Bind(R.id.shopcarListView)
    ExpandableListView shopcarListView;
    @Bind(R.id.editShopCarBtn)
    TextView editShopCarBtn;
    @Bind(R.id.topBg)
    RelativeLayout topBg;
    @Bind(R.id.contentLayout)
    RelativeLayout contentLayout;
    private ArrayList<String> group;
    private ArrayList<List<String>> child;

    @Override
    public int getLayoutRes() {
        return R.layout.shopcar_new;
    }

    @Override
    public void initView() {
        group = new ArrayList<String>();
        child = new ArrayList<List<String>>();
        addInfo("Andy",new String[]{"male","138123***","GuangZhou"});
        addInfo("Fairy",new String[]{"female","138123***","GuangZhou"});
        addInfo("Jerry",new String[]{"male","138123***","ShenZhen"});
        addInfo("Tom",new String[]{"female","138123***","ShangHai"});
        addInfo("Bill",new String[]{"male","138231***","ZhanJiang"});
        ShopCarExpandableListViewAdapter adapter = new ShopCarExpandableListViewAdapter(getContext(),group,child);
        shopcarListView.setAdapter(adapter);
    }
    /**
     * 模拟给组、子列表添加数据
     * @param g-group
     * @param c-child
     */
    private void addInfo(String g,String[] c){
        group.add(g);
        List<String> childitem = new ArrayList<String>();
        for(int i=0;i<c.length;i++){
            childitem.add(c[i]);
        }
        child.add(childitem);
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
