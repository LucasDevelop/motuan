package com.futrue.huomai.main.home.video.videolist

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.Gravity
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.window.SharePopup
import kotlinx.android.synthetic.main.activity_video_list.*

/**
 * @package    VideoListActivity.kt
 * @author     luan
 * @date       2019-11-06
 * @des        视频列表页
 */
class VideoListActivity : BaseNetActivity<VideoListPresenter>(), View.OnClickListener {

    companion object {
        val REQUEST_CODE = 0xff
        fun launch(activity: Activity) {
            val intent = Intent(activity, VideoListActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE)
        }

        fun launch(fragment: Fragment) {
            val intent = Intent(fragment.context, VideoListActivity::class.java)
            fragment.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_video_list
    val fragments = arrayOf(
        VideoListHotFragment.getNewInstance(VideoListHotFragment.TYPE_HOT),
        VideoListHotFragment.getNewInstance(VideoListHotFragment.TYPE_NEW)
    )
    val mShare by lazy { SharePopup(this) }

    override fun initView(savedInstanceState: Bundle?) {
        arrayOf(iv_back, v_share, v_praise, v_play_state, v_record).setOnClickListener(this)
        initPager()
    }

    private fun initPager() {
        val pagerAdapter = VideoPagerAdapter()
        v_pager.adapter = pagerAdapter
        v_hot.setOnClickListener {
            v_hot_text.apply {
                typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                setTextColor(resources.getColor(R.color.textColor))
            }
            v_new_text.apply {
                typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                setTextColor(resources.getColor(R.color.gray_text))
            }
            v_new_divide.visibility = View.INVISIBLE
            v_hot_divide.visibility = View.VISIBLE
            v_pager.currentItem = 0
        }
        v_new.setOnClickListener {
            v_new_text.apply {
                typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                setTextColor(resources.getColor(R.color.textColor))
            }
            v_hot_text.apply {
                typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                setTextColor(resources.getColor(R.color.gray_text))
            }
            v_hot_divide.visibility = View.INVISIBLE
            v_new_divide.visibility = View.VISIBLE
            v_pager.currentItem = 1
        }
    }

    override fun initData() {
    }

    override fun onClick(v: View) {
        when (v) {
            iv_back -> {
                finish()
            }
            v_share -> {
                mShare.showAtLocation(v, Gravity.BOTTOM, 0, 0)
            }
            v_praise -> {

            }
            v_record -> {//发布

            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

    inner class VideoPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(p0: Int): Fragment = fragments[p0]

        override fun getCount(): Int = fragments.size

    }

}

