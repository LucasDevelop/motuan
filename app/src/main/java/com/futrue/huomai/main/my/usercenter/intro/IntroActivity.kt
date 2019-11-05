package com.futrue.huomai.main.my.usercenter.intro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.blankj.utilcode.util.KeyboardUtils
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseNetActivity<IntroPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, IntroActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_intro

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun initEvent() {
        tv_cancel.setOnClickListener {
            KeyboardUtils.hideSoftInput(this)
            finish()
        }
        tv_confirm.setOnClickListener {
            KeyboardUtils.hideSoftInput(this)
            finish()
        }
        et_content.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_content.text.toString().trim().isEmpty()) {
                    tv_confirm.isEnabled = false
                    tv_confirm.setTextColor(getResColor(R.color.grey_999))
                } else {
                    tv_confirm.isEnabled = true
                    tv_confirm.setTextColor(getResColor(R.color.textColor))
                }
                tv_number.text = "${et_content.length()}/255"
            }
        })
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


}

