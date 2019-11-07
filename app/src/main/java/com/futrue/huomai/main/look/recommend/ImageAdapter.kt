package com.futrue.huomai.main.look.recommend

import android.app.Activity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.huomai.R
import com.futrue.huomai.main.look.detail.scaleimage.ScaleImageActivity

class ImageAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_img) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.itemView.setOnClickListener {
            ScaleImageActivity.launch(mContext as Activity, data, helper.adapterPosition)
        }
    }
}