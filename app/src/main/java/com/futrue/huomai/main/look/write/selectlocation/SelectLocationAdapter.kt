package com.futrue.huomai.main.look.write.selectlocation

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import javax.inject.Inject

class SelectLocationAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_selectlocation) {

    var selectPosition = -1
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            setGone(R.id.iv_select,selectPosition == helper.layoutPosition)
            setText(R.id.tv_name, "重庆市协信星光时代广场")
            setText(R.id.tv_dateil, "重庆市南岸区南坪南城大道1号")
        }
    }
}
