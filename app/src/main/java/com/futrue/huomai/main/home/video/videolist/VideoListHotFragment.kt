package com.futrue.huomai.main.home.video.videolist

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.home.video.VideoPlayerActivity
import kotlinx.android.synthetic.main.activity_intro.*

class VideoListHotFragment :
    BaseRefreshListFragment<VideoListHotPresenter, IBean, VideoListHotAdapter>() {
    companion object {
        val TYPE_HOT = 0
        val TYPE_NEW = 1
        fun getNewInstance(type: Int): VideoListHotFragment {
            val bundle = Bundle()
            bundle.putInt("type", type)
            return VideoListHotFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_video_list_hot
    override fun setRecyclerViewManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(mActivity, 3)
    }

    val type: Int by lazy { arguments?.getInt("type") ?: TYPE_HOT }

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->
            VideoPlayerActivity.launch(mActivity)
        }
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(20) { IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun reRequest() {
    }
}


