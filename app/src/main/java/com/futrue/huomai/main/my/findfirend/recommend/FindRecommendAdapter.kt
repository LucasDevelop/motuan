package com.futrue.huomai.main.my.findfirend.recommend

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class FindRecommendAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_findrecommend) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "遛遛六")
            setText(R.id.tv_type, "附近的人")
            addOnClickListener(R.id.bt_attention)
        }
    }
}
