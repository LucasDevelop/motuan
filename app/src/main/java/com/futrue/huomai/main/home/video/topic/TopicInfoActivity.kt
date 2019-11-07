package com.futrue.huomai.main.home.video.topic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.home.personaldetails.AppBarScrollingStatusChangeListener
import com.futrue.huomai.main.home.video.topic.byvideos.TopicByVideoFragment
import kotlinx.android.synthetic.main.activity_topic_info.*

/**
 * @package    TopicInfoActivity.kt
 * @author     luan
 * @date       2019-11-07
 * @des        话题详情
 */
class TopicInfoActivity : BaseNetActivity<TopicInfoPresenter>() {

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

    override fun initView(savedInstanceState: Bundle?) {
        app_bar.addOnOffsetChangedListener(object :AppBarScrollingStatusChangeListener(){
            override fun onScrollStatusChange(state: CollapsingToolbarLayoutState?) {
                if (state==CollapsingToolbarLayoutState.COLLAPSED){
                    v_title2.showView()
                }else{
                    v_title2.hideView()
                }
            }
        })
        when (type) {
            TYPE_VIDEO -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.v_content, TopicByVideoFragment.getNewInstance())
                    .commitAllowingStateLoss()
            }
            TYPE_DYNAMIC -> {
            }
        }
    }

    override fun initData() {
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

