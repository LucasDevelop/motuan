package com.futrue.huomai.main.message.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.message.chat.privateinfo.PrivateInfoActivity

class ChatActivity : BaseNetActivity<Presenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, ChatActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_chat

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("阿文", rightRes = R.mipmap.chat_info, rightClickListener = View.OnClickListener {
            PrivateInfoActivity.launch(this)
//            GroupInfoActivity.launch(this)
        })
    }

    override fun initData() {
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


}

