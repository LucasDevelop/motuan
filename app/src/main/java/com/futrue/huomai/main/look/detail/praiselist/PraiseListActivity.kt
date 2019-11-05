package com.futrue.huomai.main.look.detail.praiselist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean

class PraiseListActivity :
    BaseRefreshListActivity<PraiseListPresenter, IBean, PraiseListAdapter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PraiseListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_praise_list


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("赞过(1250)")
        mSwipeRefreshLayout.isEnabled = false
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }
}


