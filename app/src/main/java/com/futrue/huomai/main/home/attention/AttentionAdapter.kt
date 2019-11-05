package com.futrue.huomai.main.home.attention

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import javax.inject.Inject

class AttentionAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_attention) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
    }
}
