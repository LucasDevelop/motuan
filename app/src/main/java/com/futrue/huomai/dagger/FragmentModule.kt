package com.futrue.huomai.dagger

import com.futrue.huomai.main.home.HomeFragment
import com.futrue.huomai.main.home.attention.AttentionFragment
import com.futrue.huomai.main.home.hot.HotFragment
import com.futrue.huomai.main.home.personaldetails.personallook.PersonalLookFragment
import com.futrue.huomai.main.home.personaldetails.personalvideo.PersonalVideoFragment
import com.futrue.huomai.main.home.video.recommend.RecommendVideoListFragment
import com.futrue.huomai.main.home.video.topic.byvideos.TopicByVideoFragment
import com.futrue.huomai.main.home.video.videolist.VideoListHotFragment
import com.futrue.huomai.main.look.LookFragment
import com.futrue.huomai.main.look.attention.LookAttentionFragment
import com.futrue.huomai.main.look.recommend.DynamicFragment
import com.futrue.huomai.main.message.MessageFragment
import com.futrue.huomai.main.my.MyFragment
import com.futrue.huomai.main.my.findfirend.addressbook.AddressBookFragment
import com.futrue.huomai.main.my.findfirend.recommend.FindRecommendFragment
import com.futrue.huomai.main.my.look.MyLookFragment
import com.futrue.huomai.main.my.praise.look.MyPraiseLookFragment
import com.futrue.huomai.main.my.praise.video.MyPraiseVideoFragment
import com.futrue.huomai.main.my.secret.look.SecretLookFragment
import com.futrue.huomai.main.my.secret.video.SecretVideoFragment
import com.futrue.huomai.main.my.video.MyVideoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @package     com.heid.frame20181119.dagger
 * @author      lucas
 * @date        2018/11/26
 * @des         提供fragment的注入
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun injectHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun injectLookFragment(): LookFragment

    @ContributesAndroidInjector
    abstract fun injectMessageFragment(): MessageFragment

    @ContributesAndroidInjector
    abstract fun injectMyFragment(): MyFragment

    @ContributesAndroidInjector
    abstract fun injectAttentionFragment(): AttentionFragment

    @ContributesAndroidInjector
    abstract fun injectHotFragment(): HotFragment

    @ContributesAndroidInjector
    abstract fun injectPersonalVideoFragment(): PersonalVideoFragment

    @ContributesAndroidInjector
    abstract fun injectPersonalLookFragment(): PersonalLookFragment

    @ContributesAndroidInjector
    abstract fun injectRecommendFragment(): DynamicFragment

    @ContributesAndroidInjector
    abstract fun injectLookAttentionFragment(): LookAttentionFragment

    @ContributesAndroidInjector
    abstract fun injectMyVideoFragment(): MyVideoFragment

    @ContributesAndroidInjector
    abstract fun injectMyLookFragment(): MyLookFragment

    @ContributesAndroidInjector
    abstract fun injectMyPraiseLookFragment(): MyPraiseLookFragment

    @ContributesAndroidInjector
    abstract fun injectMyPraiseVideoFragment(): MyPraiseVideoFragment

    @ContributesAndroidInjector
    abstract fun injectSecretVideoFragment(): SecretVideoFragment

    @ContributesAndroidInjector
    abstract fun injectSecretLookFragment(): SecretLookFragment

    @ContributesAndroidInjector
    abstract fun injectAddressBookFragment(): AddressBookFragment

    @ContributesAndroidInjector
    abstract fun injectFindRecommendFragment(): FindRecommendFragment

    @ContributesAndroidInjector
    abstract fun injectVideoListHotFragment(): VideoListHotFragment

    @ContributesAndroidInjector
    abstract fun injectRecommendVideoListFragment():RecommendVideoListFragment

    @ContributesAndroidInjector
    abstract fun injectTopicByVideoFragment(): TopicByVideoFragment
}