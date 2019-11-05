package com.futrue.huomai.main.my.setting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean

class SettingActivity : BaseNetActivity<SettingPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, SettingActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_setting

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

