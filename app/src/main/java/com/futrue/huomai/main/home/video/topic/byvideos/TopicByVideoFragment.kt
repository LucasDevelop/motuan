package com.futrue.huomai.main.home.video.topic.byvideos

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import kotlinx.android.synthetic.main.fragment_topic_by_video.*

/**
 * @package    TopicByVideoFragment.kt
 * @author     luan
 * @date       2019-11-07
 * @des       话题视频
 */
class TopicByVideoFragment :
    BaseRefreshListFragment<TopicByVideoPresenter, IBean, TopicByVideoAdapter>() {
    companion object {
        fun getNewInstance(): TopicByVideoFragment {
            val bundle = Bundle()
            return TopicByVideoFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_topic_by_video

    override fun setRecyclerViewManager() =
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    override fun initView(savedInstanceState: Bundle?) {
        v_tab.onTabClick = { position, tab ->
            when (position) {
                0 -> {//热门
                }
                1 -> {//最新
                }
            }
        }
        v_take.setOnClickListener {

        }
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


