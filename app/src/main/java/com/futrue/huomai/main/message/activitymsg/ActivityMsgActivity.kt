package com.futrue.huomai.main.message.activitymsg

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
/**
 * @package    ActivityMsgActivity.kt
 * @author     luan
 * @date       2019-11-07
 * @des        活动消息
 */
class ActivityMsgActivity :
    BaseRefreshListActivity<ActivityMsgPresenter, IBean, ActivityMsgAdapter>() {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity) {
            val intent = Intent(activity, ActivityMsgActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment) {
            val intent = Intent(fragment.context, ActivityMsgActivity::class.java)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_msg

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("优惠活动通知")
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10){IBean()})
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun reRequest() {
    }

}


