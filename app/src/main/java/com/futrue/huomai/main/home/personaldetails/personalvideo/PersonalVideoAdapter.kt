package com.futrue.huomai.main.home.personaldetails.personalvideo

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import javax.inject.Inject

class PersonalVideoAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_personalvideo) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            //            GlideUtil.loadRoundCornersImg(mContext,"",getView(R.id.iv_cover))
            setText(R.id.tv_number,"1.2万")
        }
    }
}
