package com.futrue.huomai.main.home.shop.dynamic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import kotlinx.android.synthetic.main.activity_shop_dynamic.*

class ShopDynamicActivity : BaseNetActivity<ShopDynamicPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, ShopDynamicActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_shop_dynamic

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("丁丁家时尚搭配的小店")
    }

    override fun initData() {
        pb_goods.progress = 8f
        tv_goodsNum.text = "4.7"
        tv_goods.text = "高于同行7.34%"

        rb_service.progress = 8f
        tv_serviceNum.text = "4.7"
        tv_service.text = "高于同行7.34%"

        pb_expressage.progress = 8f
        tv_expressageNum.text = "4.7"
        tv_expressage.text = "高于同行7.34%"

        tv_aptitude.text = "资质证明未上传"
        tv_authenticationType.text = "已认证"
        tv_time.text = "2018年11月09日"
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

