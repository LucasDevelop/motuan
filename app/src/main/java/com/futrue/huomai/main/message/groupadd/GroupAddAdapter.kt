package com.futrue.huomai.main.message.groupadd

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class GroupAddAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_groupadd) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "我想静静")
            setImageResource(R.id.iv_select, R.mipmap.unselect)
        }
    }
}
