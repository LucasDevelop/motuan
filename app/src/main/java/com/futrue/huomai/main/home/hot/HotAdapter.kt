package com.futrue.huomai.main.home.hot

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class HotAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_hot) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
//            GlideUtil.loadRoundCornersImg(mContext,"",getView(R.id.iv_cover))
            setText(R.id.tv_number,"5452")
            setText(R.id.tv_title,"重庆体量最大的购物中心")
            setText(R.id.tv_name,"分我一颗糖")
            GlideUtil.loadRoundCornersImg(mContext,"",getView(R.id.iv_head))
        }
    }
}
