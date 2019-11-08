package com.futrue.huomai.main.author.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.blankj.utilcode.util.RegexUtils
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.author.code.CodeActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @package    LoginActivity.kt
 * @author     luan
 * @date       2019-11-08
 * @des        登陆
 */
class LoginActivity : BaseNetActivity<LoginPresenter>(), View.OnClickListener {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity) {
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment) {
            val intent = Intent(fragment.context, LoginActivity::class.java)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        arrayOf(
            v_back,
            v_wx_login,
            v_protocol_text1,
            v_protocol_text2,
            v_send_code
        ).setOnClickListener(this)
        v_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                if (p0.isEmpty()) {
                    v_clear.hideView()
                } else {
                    v_clear.showView()
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    override fun initData() {
    }

    override fun onClick(v: View) {
        when (v) {
            v_back -> {
                finish()
            }
            v_send_code -> {
                val phone = v_phone.text.toString().trim()
                if (phone.isNullOrEmpty()) {
                    "请输入手机号".showToast()
                    return
                }
                if (!RegexUtils.isMobileSimple(phone)) {
                    "手机号格式不正确".showToast()
                    return
                }
                if (!v_protocol.isChecked) {
                    "请先勾选用户协议".showToast()
                    return
                }
                CodeActivity.launch(this)
            }
            v_wx_login -> {

            }
            v_protocol_text1 -> {

            }
            v_protocol_text2 -> {

            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

