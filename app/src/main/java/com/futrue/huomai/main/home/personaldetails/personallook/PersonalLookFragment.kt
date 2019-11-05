package com.futrue.huomai.main.home.personaldetails.personallook

import android.os.Bundle
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.video.VideoPlayerActivity


class PersonalLookFragment :
    BaseRefreshListFragment<PersonalLookPresenter, IBean, PersonalLookAdapter>() {

    companion object {
        fun getNewInstance(): PersonalLookFragment {
            val bundle = Bundle()
            return PersonalLookFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_personal_look


    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        mBaseAdapter.setNewData(List(1) {
            IBean()
        })
        mRecyclerView?.isNestedScrollingEnabled = false
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


