package com.futrue.huomai.main.message.priselist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R

class PriseListActivity : BaseRefreshListActivity<PriseListPresenter, IBean, PriseListAdapter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PriseListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_prise_list


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("赞")
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


