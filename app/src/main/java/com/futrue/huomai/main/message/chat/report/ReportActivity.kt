package com.futrue.huomai.main.message.chat.report

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.activity_report.*


class ReportActivity : BaseNetActivity<ReportPresenter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, ReportActivity::class.java)
            activity.startActivity(intent)
        }
    }


    override fun getLayoutID(): Int = R.layout.activity_report

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("私信举报")
    }

    override fun initData() {
    }

    override fun initEvent() {
        arrayOf(rl_1, rl_2, rl_3, rl_4).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            rl_1 -> {
                iv_1.visibility = if (iv_1.visibility == View.GONE) View.VISIBLE else View.GONE
            }
            rl_2 -> {
                iv_2.visibility = if (iv_2.visibility == View.GONE) View.VISIBLE else View.GONE
            }
            rl_3 -> {
                iv_3.visibility = if (iv_3.visibility == View.GONE) View.VISIBLE else View.GONE
            }
            rl_4 -> {
                iv_4.visibility = if (iv_4.visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

}


