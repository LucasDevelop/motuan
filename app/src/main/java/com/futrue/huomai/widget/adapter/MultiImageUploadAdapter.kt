package com.futrue.huomai.widget.adapter

import android.view.View
import android.widget.ImageView
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseItemDraggableAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.huomai.R
import java.io.File

/**
 * @package    com.zhongde.haokuai.widget.adapter
 * @anthor     luan
 * @date       2019/3/12
 * @des
 */
class MultiImageUploadAdapter(view: Int) :
        BaseItemDraggableAdapter<MultiImageUploadAdapter.ImageBean, BaseViewHolder>(view, null) {


    override fun convert(helper: BaseViewHolder, item: ImageBean) {
        if (!item.isAddView) {
            if (item.originalPath?.startsWith("http")!!) {
                //显示图片
                Glide.with(mContext)
                        .load(item.originalPath)
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(SizeUtils.dp2px(6f))))
                        .into(helper.getView(R.id.v_icon))
            } else {
                //显示图片
                Glide.with(mContext)
                        .load(File(item.originalPath))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(SizeUtils.dp2px(6f))))
                        .into(helper.getView(R.id.v_icon))
            }
            helper.setGone(R.id.v_del, true)
            helper.itemView.isEnabled = true
            helper.setGone(R.id.v_icon, true)
        } else {
            helper.setGone(R.id.v_icon, false)
            helper.setGone(R.id.v_del, false)
            helper.getView<ImageView>(R.id.v_icon).setImageDrawable(null)

        }
        helper.getView<View>(R.id.v_del).setOnClickListener {
            data.removeAt(helper.adapterPosition)
            setNewData(data)
        }
        helper.addOnClickListener(R.id.tv)
    }

    class ImageBean {
        var isAddView = false
        var compressPath: String? = null
        var originalPath: String? = null
    }
}