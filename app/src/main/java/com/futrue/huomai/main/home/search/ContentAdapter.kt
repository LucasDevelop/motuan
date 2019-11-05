package com.futrue.huomai.main.home.search

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import javax.inject.Inject

class ContentAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_content) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            setText(R.id.tv_name, "北欧风格")

        }
    }
}
