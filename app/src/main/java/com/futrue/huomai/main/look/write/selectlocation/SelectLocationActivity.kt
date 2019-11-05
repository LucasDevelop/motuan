package com.futrue.huomai.main.look.write.selectlocation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.activity_select_goods.*

class SelectLocationActivity :
    BaseRefreshListActivity<SelectLocationPresenter, IBean, SelectLocationAdapter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, SelectLocationActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_select_location

    override fun loadMoreListRequest(page: Int) {
    }


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("请选择话题",rightRes = "完成",rightClickListener = View.OnClickListener {
        })
        mSwipeRefreshLayout.isEnabled = false
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) { IBean() })
        et_search
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemClickListener { _, _, position ->
            if (mBaseAdapter.selectPosition == position) {
                mBaseAdapter.selectPosition = -1
            } else {
                mBaseAdapter.selectPosition = position
            }
        }
    }


    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

}


