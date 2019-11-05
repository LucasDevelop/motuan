package com.futrue.huomai.main.message.prviatelist

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class PrviateListAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_prviatelist) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "我想静静")
            setText(R.id.tv_content, "这是哪里呢？")
            setText(R.id.tv_time, "刚刚")
        }
    }
}
