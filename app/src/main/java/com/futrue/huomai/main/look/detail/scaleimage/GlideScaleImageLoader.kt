package com.futrue.huomai.main.look.detail.scaleimage

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.youth.banner.loader.ImageLoaderInterface

/**
 * @package    com.mtyd.mtmotion.keystore.main.information.listfg
 * @anthor     luan
 * @date       2019/5/20
 * @des
 */
class GlideScaleImageLoader : ImageLoaderInterface<SubsamplingScaleImageView> {
    override fun displayImage(context: Context, path: Any?, imageView: SubsamplingScaleImageView?) {
        Glide.with(context).asBitmap().load(path).into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                imageView?.setImage(ImageSource.bitmap(resource))
            }
        })
    }

    override fun createImageView(context: Context?): SubsamplingScaleImageView {
        return SubsamplingScaleImageView(context)
    }
}