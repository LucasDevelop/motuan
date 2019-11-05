package com.futrue.huomai.utils

import android.graphics.Bitmap
import com.blankj.utilcode.util.CloseUtils
import com.blankj.utilcode.util.Utils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.futrue.huomai.BuildConfig
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import io.reactivex.annotations.Nullable
import java.io.ByteArrayOutputStream

/**
 * @创建者 shen
 * @创建时间 2019-04-29 16:33
 * @描述 分享
 */
object ShareUtil {


    /**
     * 微信好友分享
     */
    fun wechatShare(tilte: String, url: String, ImageUrl: String, text: String) {
        setWechatShera(SendMessageToWX.Req.WXSceneSession, tilte, url, ImageUrl, text)

    }

    /**
     * 微信朋友圈分享
     */
    fun wechatMomentsShare(tilte: String, url: String, ImageUrl: String, text: String) {
        setWechatShera(SendMessageToWX.Req.WXSceneTimeline, tilte, url, ImageUrl, text)
    }



    /**
     * 微信好友分享
     */
    fun wechatShare(tilte: String, url: String, bit: Bitmap, text: String) {
        setWechatShera(SendMessageToWX.Req.WXSceneSession, tilte, url, bit, text)

    }

    /**
     * 微信朋友圈分享
     */
    fun wechatMomentsShare(tilte: String, url: String, bit: Bitmap, text: String) {
        setWechatShera(SendMessageToWX.Req.WXSceneTimeline, tilte, url, bit, text)
    }

    private fun setWechatShera(type: Int, tilte: String, url: String, ImageUrl: String, text: String) {
        val api = WXAPIFactory.createWXAPI(Utils.getApp(), BuildConfig.WX_APP_ID)
        Glide.with(Utils.getApp()).asBitmap().load(ImageUrl).into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, @Nullable transition: Transition<in Bitmap>?) {
                val webpage = WXWebpageObject()
                webpage.webpageUrl = url
                val msg = WXMediaMessage(webpage)
                msg.title = tilte
                msg.description = text
                val r = Bitmap.createScaledBitmap(resource, 150, 150, true)
                msg.thumbData = bitmapToByteArray(r, true)
                val req = SendMessageToWX.Req()
                req.transaction = buildTransaction("webpage")
                req.message = msg
                req.scene = type
                api.sendReq(req)
            }
        })
    }


    private fun setWechatShera(type: Int, tilte: String, url: String, bit: Bitmap, text: String) {
        val api = WXAPIFactory.createWXAPI(Utils.getApp(), BuildConfig.WX_APP_ID)

        val webpage = WXWebpageObject()
        webpage.webpageUrl = url
        val msg = WXMediaMessage(webpage)
        msg.title = tilte
        msg.description = text
        msg.thumbData = bitmapToByteArray(bit, true)
        val req = SendMessageToWX.Req()
        req.transaction = buildTransaction("webpage")
        req.message = msg
        req.scene = type
        api.sendReq(req)

    }

    private fun buildTransaction(type: String?): String {
        return if (type == null) System.currentTimeMillis().toString() else type + System.currentTimeMillis()
    }


    private fun bitmapToByteArray(bitmap: Bitmap?, needRecycle: Boolean): ByteArray? {
        if (null == bitmap) {
            return null
        }
        if (bitmap.isRecycled) {
            return null
        }
        val output = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
        if (needRecycle) {
            bitmap.recycle()
        }
        val result = output.toByteArray()
        CloseUtils.closeIO(output)
        return result
    }
}
