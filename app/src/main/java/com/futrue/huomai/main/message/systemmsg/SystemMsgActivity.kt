package com.futrue.huomai.main.message.systemmsg

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
/**
 * @package    SystemMsgActivity.kt
 * @author     luan
 * @date       2019-11-07
 * @des        系统消息
 */
class SystemMsgActivity : BaseRefreshListActivity<SystemMsgPresenter, IBean, SystemMsgAdapter>() {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity) {
            val intent = Intent(activity, SystemMsgActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment) {
            val intent = Intent(fragment.context, SystemMsgActivity::class.java)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_system_msg

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("系统通知")
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10){ IBean() })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun reRequest() {
    }

}


