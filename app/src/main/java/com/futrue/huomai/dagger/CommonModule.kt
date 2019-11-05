package com.futrue.huomai.dagger

import android.os.Handler
import com.futrue.huomai.UserInfo
import com.futrue.huomai.data.ApiServer
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @package    com.zhongde.tinglishi.dagger
 * @anthor     lucas
 * @date       2018/12/21
 * @des        提供应用级工具
 */
@Module
class CommonModule {
    @Singleton
    @Provides
    fun provideHandler() = Handler()

    @Singleton
    @Provides
    fun provideApiServer(retrofit: Retrofit): ApiServer = retrofit.create(ApiServer::class.java)

    //提供全局单列用户对象
    @Singleton
    @Provides
    fun provideUserInfo(gson: Gson) = UserInfo(gson)
}