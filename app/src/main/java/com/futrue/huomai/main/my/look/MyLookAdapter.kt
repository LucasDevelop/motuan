package com.futrue.huomai.main.my.look

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import javax.inject.Inject

class MyLookAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_mylook) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
    }
}
