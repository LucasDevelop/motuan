package com.futrue.frame.base.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.futrue.frame.mvp.presenter.IPresenter
import com.futrue.frame.mvp.view.ISwipeView
import com.futrue.frame.widget.VpSwipeRefreshLayout

/**
 * 带下拉刷新的页面
 */
abstract class BaseRefreshFragment<P : IPresenter<*>> : BaseNetFragment<P>(),
    SwipeRefreshLayout.OnRefreshListener, ISwipeView {
    lateinit var mSwipeRefreshLayout: VpSwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val createView = super.onCreateView(inflater, container, savedInstanceState)
        mSwipeRefreshLayout = VpSwipeRefreshLayout(context)
        mSwipeRefreshLayout.setColorSchemeResources(
            android.R.color.holo_orange_light, android.R.color.holo_blue_bright,
            android.R.color.holo_green_light, android.R.color.holo_red_light
        )
        mSwipeRefreshLayout.addView(createView)
        mSwipeRefreshLayout.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mSwipeRefreshLayout.setOnRefreshListener(this)
        return mSwipeRefreshLayout
    }

    //重置刷新状态
    override fun resetRefresh() {
        if (mSwipeRefreshLayout.isRefreshing)
            mSwipeRefreshLayout.isRefreshing = false
    }
}