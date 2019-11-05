package com.futrue.huomai.main.message.chat.groupinfo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.main.message.chat.groupinfo.changename.ChangeNameActivity
import com.futrue.huomai.main.message.chat.report.ReportActivity
import kotlinx.android.synthetic.main.activity_group_info.*
import kotlinx.android.synthetic.main.activity_group_info.rl_report

class GroupInfoActivity : BaseRefreshListActivity<GroupInfoPresenter, GroupInfoBean,
        GroupInfoAdapter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, GroupInfoActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_group_info

    override fun setRecyclerViewManager(): GridLayoutManager {
        return GridLayoutManager(this, 5)
    }


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("聊天信息128)")
        mRecyclerView?.addItemDecoration(
            GridDividerItemDecoration(
                SizeUtils.dp2px(12f),
                GridDividerItemDecoration.GRIDLAYOUT
            )
        )
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(18) { GroupInfoBean(0) })
        mBaseAdapter.addData(GroupInfoBean(1))
        mBaseAdapter.addData(GroupInfoBean(2))
    }

    override fun initEvent() {
        arrayOf(tv_more, rl_groupName, rl_myName, rl_report).setOnClickListener(this)
        s_top.setOnCheckedChangeListener { compoundButton, b ->

        }
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_more -> {
            }
            rl_groupName -> {
                ChangeNameActivity.launch(this, ChangeNameActivity.groupName)
            }
            rl_myName -> {
                ChangeNameActivity.launch(this, ChangeNameActivity.myName)
            }
            rl_report -> {
                ReportActivity.launch(this)
            }

        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


