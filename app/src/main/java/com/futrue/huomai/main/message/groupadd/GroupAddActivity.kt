package com.futrue.huomai.main.message.groupadd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.message.selectgroup.SelectGroupActivity
import kotlinx.android.synthetic.main.activity_prviate_add.*

class GroupAddActivity : BaseRefreshListActivity<GroupAddPresenter, IBean, GroupAddAdapter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, GroupAddActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_group_add

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        setToolbar("发起群聊", rightRes = "完成", rightClickListener = View.OnClickListener {

        })

        val view = layoutInflater.inflate(R.layout.head_group, recyclerView, false)
        view.findViewById<RelativeLayout>(R.id.rl_group).setOnClickListener {
            SelectGroupActivity.launch(this)
        }
        view.findViewById<TextView>(R.id.tv_friend).visibility = View.VISIBLE
        mBaseAdapter.addHeaderView(view)
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(5) { IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }
}


