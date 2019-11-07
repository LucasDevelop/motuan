package com.futrue.huomai.main.home.video.recommend

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean

/**
 * @package    RecommendVideoListFragment.kt
 * @author     luan
 * @date       2019-11-07
 * @des        推荐视频列表
 */
class RecommendVideoListFragment :
    BaseRefreshListFragment<RecommendVideoListPresenter, IBean, RecommendVideoListAdapter>() {
    companion object {
        fun getNewInstance(): RecommendVideoListFragment {
            val bundle = Bundle()
            return RecommendVideoListFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_recommend_video_list
    override fun setRecyclerViewManager() =
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun reRequest() {
    }
}


