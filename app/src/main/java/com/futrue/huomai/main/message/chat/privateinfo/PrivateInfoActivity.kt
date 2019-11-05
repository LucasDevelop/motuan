package com.futrue.huomai.main.message.chat.privateinfo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.message.chat.report.ReportActivity
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.DialogWindow
import kotlinx.android.synthetic.main.activity_private_info.*

class PrivateInfoActivity : BaseNetActivity<PrivateInfoPresenter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PrivateInfoActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mBlackDialog by lazy { DialogWindow(this, "确定要将该用户加入到黑名单吗？") }
    private val mClearDialog by lazy { DialogWindow(this, "确定要将清空聊天内容吗？") }
    override fun getLayoutID(): Int = R.layout.activity_private_info

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("聊天信息")
    }

    override fun initData() {
        GlideUtil.loadRoundImg(this, "", iv_head)
        tv_name.text = "我想静静"
        tv_content.text = "我想静静"
    }

    override fun initEvent() {
        arrayOf(rl_info, bt_attention, tv_send, rl_report, tv_clear, rl_black).setOnClickListener(
            this
        )
        s_top.setOnFocusChangeListener { view, b ->

        }
        s_black.setOnFocusChangeListener { view, b ->

        }
        mBlackDialog.onClick = {
            s_black.isChecked = true
        }
        mClearDialog.onClick = {}
    }


    override fun onClick(v: View?) {
        when (v) {
            rl_info -> {

            }
            bt_attention -> {

            }
            tv_send -> {

            }
            rl_report -> {
                ReportActivity.launch(this)
            }
            tv_clear -> {
                mClearDialog.show()
            }
            rl_black -> {
                if (s_black.isChecked) {
                    s_black.isChecked = false
                } else {
                    mBlackDialog.show()
                }
            }
        }

    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


}

