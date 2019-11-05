package com.futrue.huomai.main.home.shop

import android.graphics.Paint
import android.widget.TextView
import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class ShopAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_shop) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            setText(R.id.tv_money, "99.00")
            setText(R.id.tv_title, "2019春秋新品贝雷帽")
            GlideUtil.loadRoundImg(mContext, "", getView(R.id.iv_cover))
            val tvDeletNumber = getView<TextView>(R.id.tv_deletNumber)
            tvDeletNumber.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            tvDeletNumber.text = "99.00"
            val tvDeletFlag = getView<TextView>(R.id.tv_deletFlag)
            tvDeletFlag.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }
}
