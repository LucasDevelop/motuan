package com.futrue.huomai.main.home.video.location

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.home.personaldetails.AppBarScrollingStatusChangeListener
import com.futrue.huomai.main.home.video.recommend.RecommendVideoListFragment
import com.futrue.huomai.main.look.recommend.DynamicFragment
import com.futrue.huomai.main.look.write.WriteActivity
import com.futrue.huomai.window.SharePopup
import com.yanzhenjie.permission.AndPermission
import kotlinx.android.synthetic.main.activity_location.*
import kotlinx.android.synthetic.main.activity_video_list.*

/**
 * @package    LocationActivity.kt
 * @author     luan
 * @date       2019-11-06
 * @des        定位
 */
class LocationActivity : BaseNetActivity<LocationPresenter>(), View.OnClickListener {

    companion object {
        val REQUEST_CODE = 0xff
        val TYPE_VIDEO = 0//视频入口进来的
        val TYPE_DYNAMIC = 1//动态入口进来的
        fun launch(activity: Activity, type: Int) {
            AndPermission.with(activity).runtime()
                .permission(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ).onGranted {
                    val intent = Intent(activity, LocationActivity::class.java)
                    intent.putExtra("type", type)
                    activity.startActivityForResult(intent, REQUEST_CODE)
                }.onDenied {
                    ToastUtils.showLong("请打开存储（读取、写入）、定位和读取本机信息权限！")
                }.start()
        }

        fun launch(fragment: Fragment, type: Int) {
            AndPermission.with(fragment).runtime()
                .permission(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ).onGranted {
                    val intent = Intent(fragment.context, LocationActivity::class.java)
                    intent.putExtra("type", type)
                    fragment.startActivityForResult(intent, REQUEST_CODE)
                }.onDenied {
                    ToastUtils.showLong("请打开存储（读取、写入）、定位和读取本机信息权限！")
                }.start()
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_location
    val type: Int by lazy { intent.getIntExtra("type", TYPE_VIDEO) }
    val shareDialog by lazy { SharePopup(this) }

    override fun initView(savedInstanceState: Bundle?) {
        v_map.onCreate(savedInstanceState)
        arrayOf(
            v_back1,
            v_back2,
            v_share1,
            v_share2,
            v_toolWrite1,
            v_toolWrite2
        ).setOnClickListener(this)
        app_bar.addOnOffsetChangedListener(object : AppBarScrollingStatusChangeListener() {
            override fun onScrollStatusChange(state: CollapsingToolbarLayoutState?) {
                if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                    toolbar.showView()
                } else {
                    toolbar.hideView()
                }
            }
        })
        when (type) {
            TYPE_VIDEO -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.v_content, RecommendVideoListFragment.getNewInstance())
                    .commitAllowingStateLoss()
                v_toolWrite1.hideView()
                v_toolWrite2.hideView()
                v_share1.showView()
                v_share2.showView()
            }
            TYPE_DYNAMIC -> {
                v_toolWrite1.showView()
                v_toolWrite2.showView()
                v_share1.hideView()
                v_share2.hideView()
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.v_content,
                        DynamicFragment.getNewInstance(DynamicFragment.TYPE_LOCATION)
                    )
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun initData() {
    }

    override fun onClick(v: View) {
        when (v) {
            v_back1, v_back2 -> {
                finish()
            }
            v_share1, v_share2 -> {
                shareDialog.showAtLocation(v,Gravity.BOTTOM,0,0)
            }
            v_toolWrite1, v_toolWrite2 -> {
                WriteActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

