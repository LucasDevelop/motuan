package com.futrue.huomai.main.home.hot

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.main.home.video.VideoPlayerActivity

class HotFragment : BaseRefreshListFragment<HotPresenter, IBean, HotAdapter>() {

    companion object {
        fun getNewInstance(): HotFragment {
            val bundle = Bundle()
            return HotFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_hot

    override fun setRecyclerViewManager()= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    override fun initView(savedInstanceState: Bundle?) {
        mRecyclerView?.addItemDecoration(
            GridDividerItemDecoration(
                SizeUtils.dp2px(12f),
                GridDividerItemDecoration.STAGGEREDGRIDLAYOUT
            )
        )
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


