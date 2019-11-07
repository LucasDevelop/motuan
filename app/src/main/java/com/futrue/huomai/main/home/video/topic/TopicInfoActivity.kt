package com.futrue.huomai.main.home.video.topic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.home.personaldetails.AppBarScrollingStatusChangeListener
import com.futrue.huomai.main.home.video.topic.byvideos.TopicByVideoFragment
import com.futrue.huomai.main.look.recommend.DynamicFragment
import com.futrue.huomai.main.look.write.WriteActivity
import com.futrue.huomai.window.SharePopup
import kotlinx.android.synthetic.main.activity_topic_info.*

/**
 * @package    TopicInfoActivity.kt
 * @author     luan
 * @date       2019-11-07
 * @des        话题详情
 */
class TopicInfoActivity : BaseNetActivity<TopicInfoPresenter>(), View.OnClickListener {

    companion object {
        val REQUEST_CODE = 0xff
        val TYPE_VIDEO = 0 //视频
        val TYPE_DYNAMIC = 1//动态
        fun launch(activity: Activity, type: Int) {
            val intent = Intent(activity, TopicInfoActivity::class.java)
            intent.putExtra("type", type)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment, type: Int) {
            val intent = Intent(fragment.context, TopicInfoActivity::class.java)
            intent.putExtra("type", type)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_topic_info
    val type: Int by lazy { intent.getIntExtra("type", TYPE_VIDEO) }
    val sharePop by lazy { SharePopup(this) }

    override fun initView(savedInstanceState: Bundle?) {
        app_bar.addOnOffsetChangedListener(object : AppBarScrollingStatusChangeListener() {
            override fun onScrollStatusChange(state: CollapsingToolbarLayoutState?) {
                if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                    v_title2.showView()
                } else {
                    v_title2.hideView()
                }
            }
        })
        when (type) {
            TYPE_VIDEO -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.v_content, TopicByVideoFragment.getNewInstance())
                    .commitAllowingStateLoss()
                v_share.showView()
                v_toolWrite.hideView()
            }
            TYPE_DYNAMIC -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.v_content, DynamicFragment.getNewInstance(DynamicFragment.TYPE_TOPIC))
                    .commitAllowingStateLoss()
                v_share.hideView()
                v_toolWrite.showView()
            }
        }
        arrayOf(v_back,v_share, v_toolWrite).setOnClickListener(this)
    }

    override fun initData() {
    }

    override fun onClick(v: View) {
        when (v) {
            v_back->{
                finish()
            }
            v_share -> {
                sharePop.showAtLocation(v, Gravity.BOTTOM, 0, 0)
            }
            v_toolWrite -> {
                WriteActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

