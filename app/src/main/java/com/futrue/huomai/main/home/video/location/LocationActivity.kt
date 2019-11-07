package com.futrue.huomai.main.home.video.location

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean

/**
 * @package    LocationActivity.kt
 * @author     luan
 * @date       2019-11-06
 * @des        定位
 */
class LocationActivity : BaseNetActivity<LocationPresenter>() {

    companion object {
        val REQUEST_CODE = 0xff
        val TYPE_VIDEO = 0//视频入口进来的
        val TYPE_TOPIC = 1//话题入口进来的
        fun launch(activity: Activity, type: Int) {
            val intent = Intent(activity, LocationActivity::class.java)
            intent.putExtra("type", type)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment, type: Int) {
            val intent = Intent(fragment.context, LocationActivity::class.java)
            intent.putExtra("type", type)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_location
    val type: Int by lazy { intent.getIntExtra("type", TYPE_VIDEO) }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

