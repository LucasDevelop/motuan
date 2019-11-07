package com.futrue.huomai.main.message.systemmsg

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import javax.inject.Inject

class SystemMsgAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_systemmsg) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
    }
}
