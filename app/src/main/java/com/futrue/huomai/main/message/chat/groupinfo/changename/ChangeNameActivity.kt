package com.futrue.huomai.main.message.chat.groupinfo.changename

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.activity_change_name.*

class ChangeNameActivity : BaseNetActivity<ChangeNamePresenter>() {

    companion object {
        fun launch(activity: Activity, type: Int = myName) {
            val intent = Intent(activity, ChangeNameActivity::class.java)
            intent.putExtra("type", type)
            activity.startActivity(intent)
        }

        const val myName = 0
        const val groupName = 1
    }

    var type = 0

    override fun getLayoutID(): Int = R.layout.activity_change_name

    override fun initView(savedInstanceState: Bundle?) {
        type = intent.getIntExtra("type", myName)
        val title = if (type == myName) {
            et_content.hint = "请输入昵称"
            "我在本群的昵称"
        } else {
            et_content.hint = "请输入群聊名称"
            tv_hint.visibility = View.GONE
            "修改群聊名称"
        }
        setToolbar(title, rightRes = "完成", rightClickListener = View.OnClickListener {

        })
    }

    override fun initData() {
        et_content.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_content.text.toString().trim().isNotEmpty()) {
                    iv_delet.visibility = View.VISIBLE
                } else {
                    iv_delet.visibility = View.INVISIBLE
                }

            }
        })
    }

    override fun initEvent() {
        iv_delet.setOnClickListener {
            et_content.text = Editable.Factory.getInstance().newEditable("")
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

}

