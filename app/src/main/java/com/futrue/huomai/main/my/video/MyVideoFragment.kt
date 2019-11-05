package com.futrue.huomai.main.my.video

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.main.home.personaldetails.personalvideo.PersonalVideoAdapter
import com.futrue.huomai.main.home.video.VideoPlayerActivity

class MyVideoFragment : BaseRefreshListFragment<MyVideoPresenter, IBean, PersonalVideoAdapter>() {



    override fun getLayoutID(): Int = R.layout.fragment_my_video

    override fun setRecyclerViewManager(): GridLayoutManager {
        return GridLayoutManager(mActivity, 3)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        mRecyclerView?.isNestedScrollingEnabled = false
        mRecyclerView?.addItemDecoration(
            GridDividerItemDecoration(
                SizeUtils.dp2px(5f),
                GridDividerItemDecoration.GRIDLAYOUT
            )
        )
        mBaseAdapter.setNewData(List(20) {
            IBean()
        })

    }

    override fun initData() {
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            VideoPlayerActivity.launch(mActivity)
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }
}


