package com.futrue.huomai.main.look.detail.praiselist

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class PraiseListAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_praiselist) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundImg(mContext,"",getView(R.id.iv_head))
            setText(R.id.tv_name,"纯手工小作坊")
            setText(R.id.tv_time,"2019-08-22 19:22")
        }
    }
}
