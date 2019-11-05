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
class SexPopup(context: Context) : PopupWindow(context), View.OnClickListener {

    companion object {
        val man = 0
        val woman = 1
    }

    var onClick: (Int) -> Unit = {}

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.window_sex, null)
        view.findViewById<LinearLayout>(R.id.ll_man).setOnClickListener(this)
        view.findViewById<LinearLayout>(R.id.ll_woman).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(this)
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
            R.id.ll_man -> {
                onClick(man)
            }
            R.id.ll_woman -> {
                onClick(woman)
            }

        }
        dismiss()
    }
}