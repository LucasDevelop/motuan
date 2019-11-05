package com.futrue.huomai.main.my.usercenter.settext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.RegexUtils
import com.futrue.frame.base.activity.BaseActivity
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.activity_set_text.*

class SetTextActivity : BaseNetActivity<SetTextPresenter>(), View.OnClickListener {

    companion object {
        fun launch(activity: Activity, type: Int = name) {
            val intent = Intent(activity, SetTextActivity::class.java)
            intent.putExtra("type", type)
            activity.startActivity(intent)
        }

        val name = 0
        val id = 1
    }

    private val mType by lazy { intent.getIntExtra("type", name) }
    override fun getLayoutID(): Int = R.layout.activity_set_text

    override fun initView(savedInstanceState: Bundle?) {
        if (mType == id) {
            tv_title.text = "设置火脉号"
            et_content.hint = "请输入火脉号"
            et_content.maxLines = 16
//            et_content.inputType =InputType.
            tv_hint.hint = "ID号修改为8-16位数字+字母，只能设置一次"
            tv_number.visibility = View.GONE
        }
    }

    override fun initData() {
    }

    override fun initEvent() {
        arrayOf(iv_delet, tv_cancel, tv_confirm).setOnClickListener(this)
        et_content.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_content.text.toString().trim().isNotEmpty()) {
                    iv_delet.visibility = View.VISIBLE
                } else {
                    iv_delet.visibility = View.INVISIBLE
                }

                if (mType == name) {
                    if (et_content.text.toString().trim().isEmpty()) {
                        tv_confirm.isEnabled = false
                        tv_confirm.setTextColor(getResColor(R.color.grey_999))
                    } else {
                        tv_confirm.isEnabled = true
                        tv_confirm.setTextColor(getResColor(R.color.textColor))
                    }
                    tv_number.text = "${et_content.length()}/12"
                } else {
                    if (et_content.text.toString().trim().length > 5) {
                        tv_confirm.isEnabled = true
                        tv_confirm.setTextColor(getResColor(R.color.textColor))
                    } else {
                        tv_confirm.isEnabled = false
                        tv_confirm.setTextColor(getResColor(R.color.grey_999))
                    }
                }
            }
        })
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_delet -> {
                et_content.text = Editable.Factory.getInstance().newEditable("")
            }
            tv_cancel -> {
                KeyboardUtils.hideSoftInput(this)
                finish()
            }
            tv_confirm -> {
                val content = et_content.text.toString().trim()
                if (mType == id) {
                    if (!RegexUtils.isMatch(".*[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]",content)) {
                        "ID必须包含数字和字母".showToast()
                        return
                    }
                }
                KeyboardUtils.hideSoftInput(this)
                finish()
            }
        }
    }

    override fun requestSuccess(
        bean: IBean,
        requestMode: BaseModel.RequestMode,
        requestTag: Any
    ) {

    }

}


