package com.futrue.huomai.main.look.write.selectgoods

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class SelectGoodsAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_selectgoods) {
    var selectPosition = -1
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            if (selectPosition == helper.layoutPosition) {
                setImageResource(R.id.iv_select, R.mipmap.select)
            } else {
                setImageResource(R.id.iv_select, R.mipmap.unselect)
            }
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_img))
            setText(R.id.tv_name, "小罐茶茶具茶水分离杯")
            setText(R.id.tv_money, "￥ 12800")
        }
    }
}
