package com.futrue.huomai.main.home.shop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.main.home.shop.dynamic.ShopDynamicActivity
import com.futrue.huomai.utils.GlideUtil
import kotlinx.android.synthetic.main.activity_shop.*



class ShopActivity : BaseRefreshListActivity<ShopPresenter, IBean, ShopAdapter>(),
    View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, ShopActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_shop

    override fun setRecyclerViewManager(): GridLayoutManager {
        return GridLayoutManager(this, 2)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        mRecyclerView?.isFocusable = false
    }



    override fun initData() {
        iv_title.text = "丁丁家时尚搭配qqq"
        tv_name.text = "丁丁家时尚搭配qqq"
        GlideUtil.loadRoundImg(this, "", iv_head)
        tv_content.text = "2小时前来过  总销量 1258 件"
        tv_goods.text = "4.7"
        tv_goodsGrade.text = "高"
        tv_service.text = "4.7"
        tv_serviceGrade.text = "高"
        tv_expressage.text = "4.7"
        tv_expressageGrade.text = "高"
        tv_goodsNum.text = "25件"

        mRecyclerView?.addItemDecoration(
            GridDividerItemDecoration(
                SizeUtils.dp2px(12f),
                GridDividerItemDecoration.GRIDLAYOUT
            )
        )

        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        arrayOf(iv_back, bt_send, ll_dynamic).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_back -> {
                finish()
            }
            bt_send -> {

            }
            ll_dynamic -> {
                ShopDynamicActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


