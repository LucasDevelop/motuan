package com.futrue.huomai.main.message.selectgroup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R

class SelectGroupActivity :
    BaseRefreshListActivity<SelectGroupPresenter, IBean, SelectGroupAdapter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, SelectGroupActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_select_group


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("选择一个群")
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(5) { IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


