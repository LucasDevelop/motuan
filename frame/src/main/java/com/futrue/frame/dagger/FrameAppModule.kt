package com.futrue.frame.dagger

import com.futrue.frame.bus.AppBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *         提供一些通用型工具
 */
@Module
class FrameAppModule {
    @Singleton
    @Provides
    fun provideBus() = AppBus
}