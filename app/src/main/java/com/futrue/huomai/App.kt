package com.futrue.huomai

import android.content.Context
import com.futrue.frame.FrameApp
import com.futrue.frame.config.FrameInitConfig
import com.futrue.huomai.dagger.DaggerAppComponent
import com.futrue.huomai.inteceptor.ParamsInterceptor
import com.futrue.huomai.utils.ImageLoader
import com.previewlibrary.ZoomMediaLoader
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @package     com.bananafish.coupon
 * @author        (870018077)
 * @des         程序入口
 */
class App : FrameApp() {
    @Inject
    lateinit var userInfo: UserInfo

    companion object {
        var context: Context by Delegates.notNull()
        var instance: App by Delegates.notNull()
    }


    override fun initFrameConfig() {
        instance = this
        context = applicationContext

//        FrameInitConfig.BASE_URL = "http://www.xiangjiaoyu.vip"
        FrameInitConfig.BASE_URL = "http://yhq.kuaimacode.com"
        //初始化用户状态
        userInfo.initUserInfo()
        //加入插入器
        FrameInitConfig.addInterceptor(ParamsInterceptor())

        ZoomMediaLoader.getInstance().init(ImageLoader())

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().create(this)
    }

}