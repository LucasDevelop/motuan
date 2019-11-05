package com.futrue.huomai.main.look.write.selectlabel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SelectLabelActivity : BaseNetActivity<SelectLabelPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, SelectLabelActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mVals = arrayOf(
        "Hello", "Android", "Weclome Hi ", "Button",
        "TextView", "Hello", "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
        "Android", "Weclome Hello", "Button Text", "TextView"
    )

    override fun getLayoutID(): Int = R.layout.activity_select_label

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("请选择话题",rightRes = "完成",rightClickListener = View.OnClickListener {
            flowLayout.selectedList
        })
    }

    override fun initData() {
        flowLayout.adapter = object : TagAdapter<String>(mVals) {
            override fun getView(parent: FlowLayout, position: Int, s: String): View {
                val tv =
                    layoutInflater.inflate(R.layout.item_message_tv, flowLayout, false) as TextView
                tv.text = s
                return tv
            }
        }
    }

    override fun initEvent() {

    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

