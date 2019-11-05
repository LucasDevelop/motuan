package com.futrue.huomai.dagger

import android.app.Application
import com.futrue.huomai.App
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @package     com.heid.frame20181119.dagger
 * @author      lucas
 * @date        2018/11/23
 * @des         提供应用级上下文
 */
@Module(includes = [AndroidInjectionModule::class])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideApplication(app: App) :Application

}