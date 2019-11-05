package com.futrue.huomai.main.message.selectgroup

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class SelectGroupAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_selectgroup) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head),1)
            setText(R.id.tv_name, "我想静静")
            setText(R.id.tv_number, "（10人）")
        }
    }
}
