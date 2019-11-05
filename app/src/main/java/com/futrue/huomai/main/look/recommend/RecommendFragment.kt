package com.futrue.huomai.main.look.recommend

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.look.detail.LookDetailActivity
import com.futrue.huomai.main.look.label.LabelActivity

class RecommendFragment : BaseRefreshListFragment<RecommendPresenter, IBean, RecommendAdapter>() {

    companion object {
        fun getNewInstance(): RecommendFragment {
            val bundle = Bundle()
            return RecommendFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_recommend

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) {
            IBean()
        })
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            LookDetailActivity.launch(mActivity)
        }

        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.tv_more -> {
                }
                R.id.bt_messageLabel -> {
                    LabelActivity.launch(mActivity)
                }
                R.id.bt_locationLabel -> {
                    LabelActivity.launch(mActivity)
                }
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


