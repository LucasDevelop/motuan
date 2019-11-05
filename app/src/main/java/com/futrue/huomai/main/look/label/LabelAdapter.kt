package com.futrue.huomai.main.look.label

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import javax.inject.Inject

class LabelAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_label) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
    }
}
