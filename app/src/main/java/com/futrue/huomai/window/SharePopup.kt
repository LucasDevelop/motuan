package com.futrue.huomai.window

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView

import com.blankj.utilcode.util.CloseUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.futrue.frame.config.FrameInitConfig
import com.futrue.huomai.R
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import io.reactivex.annotations.NonNull
import io.reactivex.annotations.Nullable
import java.io.ByteArrayOutputStream


/**
 * @创建者     shen
 * @创建时间   2019-06-27 17:12
 * @描述
 */
class SharePopup(context: Context, isBlack: Boolean = false, isReport: Boolean = true) :
    PopupWindow(context),
    View.OnClickListener {

    companion object {
        val wechat = 0
        val friends = 1
        val report = 2
        val black = 3
    }

    var onClick: (Int) -> Unit = {}

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.window_share, null)
        view.findViewById<LinearLayout>(R.id.ll_wechat).setOnClickListener(this)
        view.findViewById<LinearLayout>(R.id.ll_friends).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(this)
        if (isBlack) {
            view.findViewById<LinearLayout>(R.id.ll_black).apply {
                setOnClickListener(this@SharePopup)
                visibility = View.VISIBLE
            }
        }
        if (isReport) {
            view.findViewById<LinearLayout>(R.id.ll_report).apply {
                setOnClickListener(this@SharePopup)
                visibility = View.VISIBLE
            }
        }
        this.contentView = view
        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.MATCH_PARENT
        this.isFocusable = true
        this.isClippingEnabled = false
        val dw = ColorDrawable(Color.argb(90, 0, 0, 0))
        this.setBackgroundDrawable(dw)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_wechat -> {
                onClick(wechat)
            }
            R.id.ll_friends -> {
                onClick(friends)
            }
            R.id.ll_report -> {
                onClick(report)
            }
            R.id.ll_black -> {
                onClick(black)
            }
        }
        dismiss()
    }
}