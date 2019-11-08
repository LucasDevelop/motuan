package com.futrue.huomai.main.author.code

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import kotlinx.android.synthetic.main.activity_code.*

/**
 * @package    CodeActivity.kt
 * @author     luan
 * @date       2019-11-08
 * @des        验证码
 */
class CodeActivity : BaseNetActivity<CodePresenter>(),View.OnClickListener {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity, phone: String) {
            val intent = Intent(activity, CodeActivity::class.java)
            intent.putExtra("phone", phone)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment, phone: String) {
            val intent = Intent(fragment.context, CodeActivity::class.java)
            intent.putExtra("phone", phone)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_code
    val phone by lazy { intent.getStringExtra("phone") ?: "" }
    val task = TimeTask()

    override fun initView(savedInstanceState: Bundle?) {
        v_hint.text = "验证码已发送至+86 ${phone}"
        task.start()
        arrayOf(v_back,v_send_code,v_protocol_text1,v_protocol_text2).setOnClickListener(this)
        v_code.onInputComplete = {
            finish()
        }
    }

    override fun initData() {
    }

    override fun onClick(v: View) {
        when (v) {
            v_back -> {
                finish()
            }
            v_send_code -> {
            }
            v_protocol_text1->{

            }
            v_protocol_text2->{

            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

    inner class TimeTask : Runnable {
        var tick = 60
        var isRunning = false
        override fun run() {
            if (tick < 0) {
                stop()
                v_send_code.isEnabled = true
                return
            }
            v_send_code.text = "重新发送(${tick--})"
            mHandler.postDelayed(this, 1000)
        }

        fun start() {
            if (isRunning)
                return
            v_send_code.isEnabled = false
            isRunning = true
            tick = 60
            mHandler.post(this)
        }

        fun stop() {
            isRunning = false
            mHandler.removeCallbacks(this)
        }
    }

}

