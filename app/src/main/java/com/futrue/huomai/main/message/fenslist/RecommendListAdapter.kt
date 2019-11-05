package com.futrue.huomai.main.message.fenslist

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class RecommendListAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_recommendlist) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "遛遛六")
            setText(R.id.tv_time, "可能认识的人")
            setText(R.id.bt_1, "男")
            setText(R.id.bt_2, "天秤座")
            setText(R.id.bt_3, "四川 成都")
            addOnClickListener(R.id.bt_attention, R.id.iv_delet)
        }
    }
}
