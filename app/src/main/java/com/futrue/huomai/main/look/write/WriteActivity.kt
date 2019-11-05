package com.futrue.huomai.main.look.write

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.look.friendlist.FriendListActivity
import com.futrue.huomai.main.look.write.selectgoods.SelectGoodsActivity
import com.futrue.huomai.main.look.write.selectlabel.SelectLabelActivity
import com.futrue.huomai.main.look.write.selectlocation.SelectLocationActivity
import com.futrue.huomai.window.TakePhotoWindow
import kotlinx.android.synthetic.main.activity_write.*
import org.devio.takephoto.model.TResult

class WriteActivity : BaseNetActivity<WritePresenter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, WriteActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_write

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        et_content.text.toString().trim()
        tv_contentSize.text = "最多1000字"
        bt_2.text = "重庆市"
        v_upload_img.takePhotoWindow = TakePhotoWindow(this, takePhoto)
        v_upload_img.maxPic = 9
    }

    override fun initEvent() {
        arrayOf(iv_back, ll_message, ll_shopping, bt_1, bt_2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_back -> {

                finish()
            }
            ll_message -> {
                SelectLabelActivity.launch(this)
            }
            ll_shopping -> {
                SelectGoodsActivity.launch(this)
            }
            bt_1 -> {
                FriendListActivity.launch(this)
            }
            bt_2 -> {
                SelectLocationActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun takeSuccess(result: TResult) {
        v_upload_img.takeSuccess(result)
    }

}

