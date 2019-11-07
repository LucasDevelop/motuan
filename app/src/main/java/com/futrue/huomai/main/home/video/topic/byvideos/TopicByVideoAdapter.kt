package com.futrue.huomai.main.home.video.topic.byvideos

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import javax.inject.Inject

class TopicByVideoAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_recommendvideolist) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
    }
}
