package com.futrue.frame.widget;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.futrue.frame.R;


/**
 * <b>@项目名:</b> ESchool<br>
 * <b>@创建者:</b> 陆先俊v
 * <b>@创建时间:</b> 2015/11/3 16:05<br>
 * <b>@邮箱：</b> CarlLu0712@163.com<br>
 * <p/>
 * <b>@描述:</b> fragment绑定的tabhost帮助类<br>
 */
public class FragmentTabManager {
    private FragmentActivity mContext;
    private FragmentTabHostManager mFragmentTabHost;
    private Class[] mFragments;
    public TextView mTabNumber;

    public FragmentTabManager(FragmentActivity contenxt, FragmentTabHostManager tabHost, Class[] fragments) {
        this.mContext = contenxt;
        mFragmentTabHost = tabHost;
        this.mFragments = fragments;
    }

    /**
     * 初始化数据
     *
     * @param tabNames   条目的名字
     * @param resID      framlayout资源的id
     * @param imageResID 图片的资源id
     */
    public void bindFragment(String[] tabNames, int resID, int[] imageResID) {
        //将tabHost跟内容部分绑定
        mFragmentTabHost.setup(mContext, mContext.getSupportFragmentManager(), resID);

        //添加数据
        TabHost.TabSpec tabSpec;
        for (int i = 0; i < mFragments.length; i++) {
            if (i == 2)
                tabSpec = mFragmentTabHost.newTabSpec(tabNames[i]).setIndicator(getCenterView(i, tabNames[i], imageResID[i]));
            else
                tabSpec = mFragmentTabHost.newTabSpec(tabNames[i]).setIndicator(getView(i, tabNames[i], imageResID[i]));
                //添加到tabHost中

            mFragmentTabHost.addTab(tabSpec, mFragments[i], null);
        }
        //去除中间的分割线
        mFragmentTabHost.getTabWidget().setDividerDrawable(new ColorDrawable(Color.TRANSPARENT));


    }

    /**
     * 获取底部份的View对象
     *
     * @param i
     * @param tabNames   名字
     * @param imageResID 图片的id
     * @return view对象
     */
    private View getView(int i, String tabNames, int imageResID) {
        RelativeLayout view = (RelativeLayout) View.inflate(mContext, R.layout.view_tab_host, null);
        LinearLayout rootView = (LinearLayout) view.findViewById(R.id.ll_tab_rootView);
        rootView.setOrientation(LinearLayout.VERTICAL);
        ImageView tabImage = (ImageView) view.findViewById(R.id.iv_tab_imageView);
        TextView tabTextView = (TextView) view.findViewById(R.id.tv_tab_textView);
        if (i == 1)
            mTabNumber = (TextView) view.findViewById(R.id.tv_tab_number);

        //设置字体大小
        tabTextView.setText(tabNames);
//        tabTextView.setTextColor(mContext.getResources().getColorStateList(R.color.mow_main_tab_tv_selector));

        tabImage.setImageResource(imageResID);
        return view;
    }


    private View getCenterView(int i, String tabNames, int imageResID) {
        LinearLayout rootView = (LinearLayout) View.inflate(mContext, R.layout.view_center_tab_host, null);
        ImageView tabImage = (ImageView) rootView.findViewById(R.id.iv_tab_imageView);
        TextView tabTextView = (TextView) rootView.findViewById(R.id.tv_tab_textView);
        //设置字体大小
        tabTextView.setText(tabNames);
        tabImage.setImageResource(imageResID);
        return rootView;
    }
}
