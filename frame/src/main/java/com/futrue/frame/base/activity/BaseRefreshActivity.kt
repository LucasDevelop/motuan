package com.futrue.frame.base.activity

import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import com.futrue.frame.mvp.presenter.IPresenter
import com.futrue.frame.mvp.view.ISwipeView
import com.futrue.frame.widget.VpSwipeRefreshLayout

/**
 * 带下拉刷新的页面
 */
abstract class BaseRefreshActivity<P : IPresenter<*>> : BaseNetActivity<P>(),ISwipeView,
    SwipeRefreshLayout.OnRefreshListener {

    lateinit var mSwipeRefreshLayout: VpSwipeRefreshLayout

    override fun setContentView(layoutResID: Int) {
        val inflate = LayoutInflater.from(this).inflate(layoutResID, null)
        mSwipeRefreshLayout = VpSwipeRefreshLayout(this)
        mSwipeRefreshLayout.setColorSchemeResources(
            android.R.color.holo_orange_light, android.R.color.holo_blue_bright,
            android.R.color.holo_green_light, android.R.color.holo_red_light
        )
        mSwipeRefreshLayout.addView(inflate)
        mSwipeRefreshLayout.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mSwipeRefreshLayout.setOnRefreshListener(this)
        super.setContentView(mSwipeRefreshLayout)
    }

    //重置刷新状态
    override fun resetRefresh() {
        if (mSwipeRefreshLayout.isRefreshing)
            mSwipeRefreshLayout.isRefreshing = false
    }
}