package com.futrue.huomai.main.look.detail.scaleimage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_scale_image.*

/**
 * @package    ScaleImageActivity.kt
 * @author     luan
 * @date       16:19
 * @des        大图缩放
 */
class ScaleImageActivity : BaseNetActivity<ScaleImagePresenter>() {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity, images: List<String>, selectPosition: Int = 0) {
            val intent = Intent(activity, ScaleImageActivity::class.java)
            val array = Array(images.size) { images[it] }
            intent.putExtra("images", array)
            intent.putExtra("selectPosition", selectPosition)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment, images: Array<String>, selectPosition: Int = 0) {
            val intent = Intent(fragment.context, ScaleImageActivity::class.java)
            intent.putExtra("images", images)
            intent.putExtra("selectPosition", selectPosition)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_scale_image

    val images: Array<String> by lazy { intent.getStringArrayExtra("images") }
    val selectPosition: Int by lazy { intent.getIntExtra("selectPosition", 0) }

    override fun initView(savedInstanceState: Bundle?) {
        v_banner.setImageLoader(GlideScaleImageLoader())
        v_banner.setBannerStyle(BannerConfig.NUM_INDICATOR)
        v_banner.setImages(images.toList())
        v_banner.isAutoPlay(false)
        v_banner.start()
        v_root.setOnClickListener { finish() }
    }

    override fun initData() {
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

