package com.futrue.huomai.main


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View

import com.blankj.utilcode.util.ToastUtils
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.widget.FragmentTabManager
import com.futrue.huomai.R
import com.futrue.huomai.main.home.HomeFragment
import com.futrue.huomai.main.look.LookFragment
import com.futrue.huomai.main.message.MessageFragment
import com.futrue.huomai.main.my.MyFragment
import com.yanzhenjie.permission.AndPermission
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import kotlin.system.exitProcess


/**
 * @创建者 shen
 * @创建时间 2019/3/20 15:58
 * @描述
 */
class MainActivity : BaseNetActivity<MainPresenter>() {

    companion object {
        fun launch(baseActivity: Activity) {
            val intent = Intent(baseActivity, MainActivity::class.java)
            baseActivity.startActivity(intent)
        }
    }

    private var mBackPressedTime by Delegates.observable(0L) { _, old, new ->
        if (new - old > 1000) {
            ToastUtils.showShort("再按一次退出程序")
        } else {
            exitProcess(0)
        }
    }


    private lateinit var mManager: FragmentTabManager
    override fun getLayoutID(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mManager = FragmentTabManager(
            this, mainTabHost, arrayOf(
                HomeFragment::class.java, LookFragment::class.java, null,
                MessageFragment::class.java, MyFragment::class.java
            )
        )

        mManager.bindFragment(
            arrayOf(
                getString(R.string.tab_home),
                getString(R.string.tab_look),
                getString(R.string.tab_publish),
                getString(R.string.tab_message),
                getString(R.string.tab_my)
            )
            , R.id.v_content
            , intArrayOf(
                R.drawable.main_selectoer_tab_home,
                R.drawable.main_selectoer_tab_look,
                R.mipmap.publish,
                R.drawable.main_selectoer_tab_message,
                R.drawable.main_selectoer_tab_my
            )
        )


        AndPermission.with(this)
            .runtime()
            .permission(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
            )
            .onDenied {
                ToastUtils.showLong("请打开存储（读取、写入）、定位和读取本机信息权限！")
            }.start()

        ToastUtils.setGravity(Gravity.CENTER, 0, 0)


    }

    override fun initData() {
    }

    override fun initEvent() {

        mainTabHost.setOnTabChangedListener { tabId ->
            if (tabId == getString(R.string.tab_publish)) {

            } else {
                if (mainTabHost.isAttached) {
                    val ft = mainTabHost.doTabChanged(tabId, null)
                    ft?.commitAllowingStateLoss()
                }
            }
        }
    }


    override fun onBackPressed() {
        mBackPressedTime = System.currentTimeMillis()
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {

    }

    override fun onResume() {
        super.onResume()
        refreshMsgCount()
    }


    /**
     * 刷新消息
     */
    private fun refreshMsgCount() {
//        val i =JMessageClient.getAllUnReadMsgCount()
        val i = 0
        println("未读消息=$i")
        if (i > 99) {
            mManager.mTabNumber.text = "99+"
            mManager.mTabNumber.visibility = View.VISIBLE
        } else if (i <= 0) {
            mManager.mTabNumber.visibility = View.GONE
        } else {
            mManager.mTabNumber.text = i.toString()
            mManager.mTabNumber.visibility = View.VISIBLE
        }

    }
}
