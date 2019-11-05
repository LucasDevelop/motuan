package com.futrue.huomai.main.home.personaldetails;

import android.support.design.widget.AppBarLayout;


/**
 * @创建者 lucas
 * @创建时间 2018/1/8 0008 16:08
 * @描述 appbar的滑动状态监听，将具体的滑动数值转化为状态值
 */

public abstract class AppBarScrollingStatusChangeListener implements AppBarLayout.OnOffsetChangedListener {
    private CollapsingToolbarLayoutState state;

    //定义出CollapsingToolbarLayout展开、折叠、中间，这三种状态。
    public enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (state != CollapsingToolbarLayoutState.EXPANDED) {
                state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
            }
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()-80) {
            if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
            }
        } else {
            if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
            }
        }
        onScrollStatusChange(state);
    }

    public abstract void onScrollStatusChange(CollapsingToolbarLayoutState state);
}
