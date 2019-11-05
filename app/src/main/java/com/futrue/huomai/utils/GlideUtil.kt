package com.futrue.huomai.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.support.annotation.NonNull
import android.widget.ImageView
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.VideoDecoder.FRAME_OPTION
import com.bumptech.glide.request.RequestOptions
import com.futrue.frame.config.FrameInitConfig
import com.futrue.huomai.R
import java.io.File
import java.security.MessageDigest


/**
 * @package    com.zhongde.haokuai.utils
 * @anthor     luan
 * @date       2019/3/16
 * @des
 */
object GlideUtil {

    //加载圆形图片
    fun loadRoundImg(
        context: Context?,
        imgUrl: String?,
        view: ImageView,
        holderImg: Int = R.mipmap.my_default_avatar,
        errorImg: Int = R.mipmap.my_default_avatar
    ) {
        if (context == null) {
            return
        }
        var url = imgUrl
        if (!imgUrl.isNullOrEmpty()) {
            if (!imgUrl.startsWith("http")) {
                url = FrameInitConfig.BASE_URL + imgUrl
            }
        }
        Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().placeholder(holderImg).error(errorImg).circleCrop())
                .load(url)
                .into(view)
    }


    //加载圆形图片
    fun loadRoundCornersImg(
            context: Context?,
            imgUrl: String?,
            view: ImageView,
            Round: Int = SizeUtils.dp2px(6F),
            holderImg: Int = R.mipmap.my_default_avatar,
            errorImg: Int = R.mipmap.my_default_avatar
    ) {
        if (context == null) {
            return
        }
        var url = imgUrl
        if (!imgUrl.isNullOrEmpty()) {
            if (!imgUrl.startsWith("http")) {
                url = FrameInitConfig.BASE_URL + imgUrl
            }
        }
        Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().placeholder(holderImg).error(errorImg))
                .load(url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(Round)))
                .into(view)

    }


    //加载圆形图片
    fun loadRoundCornersImg(
            context: Activity?,
            imgUrl: String?,
            view: ImageView,
            Round: Int = SizeUtils.dp2px(6F),
            holderImg: Int = R.mipmap.my_default_avatar,
            errorImg: Int = R.mipmap.my_default_avatar
    ) {
        if (context == null) {
            return
        }
        var url = imgUrl
        if (!imgUrl.isNullOrEmpty()) {
            if (!imgUrl.startsWith("http")) {
                url = FrameInitConfig.BASE_URL + imgUrl
            }
        }

        Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().placeholder(holderImg).error(errorImg))
                .load(url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(Round)))
                .into(view)

    }

    //加载圆形图片
    fun loadRoundCornersImg(
            context: Context?,
            imgUrl: File?,
            view: ImageView,
            Round: Int = SizeUtils.dp2px(6F),
            holderImg: Int = R.mipmap.my_default_avatar,
            errorImg: Int = R.mipmap.my_default_avatar
    ) {
        if (context == null) {
            return
        }
        Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().placeholder(holderImg).error(errorImg))
                .load(imgUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(Round)))
                .into(view)

    }

    //加载圆形图片
    fun loadRoundCornersImg(
            context: Context?,
            imgUrl: Bitmap,
            view: ImageView,
            Round: Int = SizeUtils.dp2px(6F),
            holderImg: Int = R.mipmap.my_default_avatar,
            errorImg: Int = R.mipmap.my_default_avatar
    ) {
        if (context == null) {
            return
        }
        Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().placeholder(holderImg).error(errorImg))
                .load(imgUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(Round)).fitCenter())
                .into(view)

    }


    //加载视频封面图片
    fun loadVideoScreenshot(context: Context?, uri: String, imageView: ImageView, frameTimeMicros: Long) {
        if (context == null) {
            return
        }
        val requestOptions = RequestOptions.frameOf(frameTimeMicros)
        requestOptions.set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST)
        requestOptions.transform(object : BitmapTransformation() {
            override fun transform(@NonNull pool: BitmapPool, @NonNull toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
                return toTransform
            }

            override fun updateDiskCacheKey(messageDigest: MessageDigest) {
                try {
                    messageDigest.update((context.packageName + "RotateTransform").toByteArray(charset("utf-8")))
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        })

        Glide.with(context).load(uri).apply(requestOptions).into(imageView)
    }


}