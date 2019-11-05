package com.futrue.huomai.main.home.attention

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.main.home.hot.HotAdapter
import com.futrue.huomai.main.home.video.VideoPlayerActivity


class AttentionFragment : BaseRefreshListFragment<AttentionPresenter, IBean, HotAdapter>() {

    companion object {
        fun getNewInstance(): AttentionFragment {
            val bundle = Bundle()
            return AttentionFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_attention


    override fun setRecyclerViewManager(): LinearLayoutManager {
        return GridLayoutManager(mActivity, 2)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mRecyclerView?.addItemDecoration(GridDividerItemDecoration(SizeUtils.dp2px(12f),
            GridDividerItemDecoration.GRIDLAYOUT))
        mBaseAdapter.setNewData(List(10) {
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


