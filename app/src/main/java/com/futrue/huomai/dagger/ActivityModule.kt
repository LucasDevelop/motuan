package com.futrue.huomai.dagger


import com.futrue.huomai.main.MainActivity
import com.futrue.huomai.main.home.personaldetails.PersonalDetailsActivity
import com.futrue.huomai.main.home.search.SearchActivity
import com.futrue.huomai.main.home.shop.ShopActivity
import com.futrue.huomai.main.home.shop.dynamic.ShopDynamicActivity
import com.futrue.huomai.main.home.video.VideoPlayerActivity
import com.futrue.huomai.main.look.detail.LookDetailActivity
import com.futrue.huomai.main.look.detail.praiselist.PraiseListActivity
import com.futrue.huomai.main.look.friendlist.FriendListActivity
import com.futrue.huomai.main.look.label.LabelActivity
import com.futrue.huomai.main.look.write.WriteActivity
import com.futrue.huomai.main.look.write.selectgoods.SelectGoodsActivity
import com.futrue.huomai.main.look.write.selectlabel.SelectLabelActivity
import com.futrue.huomai.main.look.write.selectlocation.SelectLocationActivity
import com.futrue.huomai.main.message.chat.ChatActivity
import com.futrue.huomai.main.message.chat.groupinfo.GroupInfoActivity
import com.futrue.huomai.main.message.chat.groupinfo.changename.ChangeNameActivity
import com.futrue.huomai.main.message.chat.privateinfo.PrivateInfoActivity
import com.futrue.huomai.main.message.chat.report.ReportActivity
import com.futrue.huomai.main.message.commentlist.CommentListActivity
import com.futrue.huomai.main.message.fenslist.FensListActivity
import com.futrue.huomai.main.message.groupadd.GroupAddActivity
import com.futrue.huomai.main.message.priselist.PriseListActivity
import com.futrue.huomai.main.message.prviateadd.PrviateAddActivity
import com.futrue.huomai.main.message.prviatelist.PrviateListActivity
import com.futrue.huomai.main.message.selectgroup.SelectGroupActivity
import com.futrue.huomai.main.my.findfirend.FindFirendActivity
import com.futrue.huomai.main.my.setting.SettingActivity
import com.futrue.huomai.main.my.usercenter.UserCenterActivity
import com.futrue.huomai.main.my.usercenter.intro.IntroActivity
import com.futrue.huomai.main.my.usercenter.settext.SetTextActivity
import com.futrue.huomai.main.my.usercenter.userhead.UserHeadActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @package     com.heid.frame20181119
 * @author      lucas
 * @date        2018/11/23
 * @des
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun injectMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun injectVideoPlayerActivity(): VideoPlayerActivity

    @ContributesAndroidInjector
    abstract fun injectFriendListActivity(): FriendListActivity

    @ContributesAndroidInjector
    abstract fun injectPersonalDetailsActivity(): PersonalDetailsActivity

    @ContributesAndroidInjector
    abstract fun injectShopActivity(): ShopActivity

    @ContributesAndroidInjector
    abstract fun injectShopDynamicActivity(): ShopDynamicActivity

    @ContributesAndroidInjector
    abstract fun injectSearchActivity(): SearchActivity

    @ContributesAndroidInjector
    abstract fun injectLookDetailActivity(): LookDetailActivity

    @ContributesAndroidInjector
    abstract fun injectPraiseListActivity(): PraiseListActivity

    @ContributesAndroidInjector
    abstract fun injectLabelActivity(): LabelActivity

    @ContributesAndroidInjector
    abstract fun injectWriteActivity(): WriteActivity

    @ContributesAndroidInjector
    abstract fun injectSelectLabelActivity(): SelectLabelActivity

    @ContributesAndroidInjector
    abstract fun injectSelectGoodsActivity(): SelectGoodsActivity

    @ContributesAndroidInjector
    abstract fun injectSelectLocationActivity(): SelectLocationActivity

    @ContributesAndroidInjector
    abstract fun injectPriseListActivity(): PriseListActivity

    @ContributesAndroidInjector
    abstract fun injectFensListActivity(): FensListActivity

    @ContributesAndroidInjector
    abstract fun injectCommentListActivity(): CommentListActivity

    @ContributesAndroidInjector
    abstract fun injectPrviateListActivity(): PrviateListActivity

    @ContributesAndroidInjector
    abstract fun injectPrviateAddActivity(): PrviateAddActivity

    @ContributesAndroidInjector
    abstract fun injectGroupAddActivity(): GroupAddActivity

    @ContributesAndroidInjector
    abstract fun injectSelectGroupActivity(): SelectGroupActivity

    @ContributesAndroidInjector
    abstract fun injectChatActivity(): ChatActivity

    @ContributesAndroidInjector
    abstract fun injectInfoActivity(): PrivateInfoActivity

    @ContributesAndroidInjector
    abstract fun injectGroupInfoActivity(): GroupInfoActivity

    @ContributesAndroidInjector
    abstract fun injectChangeNameActivity(): ChangeNameActivity

    @ContributesAndroidInjector
    abstract fun injectReportActivity(): ReportActivity

    @ContributesAndroidInjector
    abstract fun injectFindFirendActivity(): FindFirendActivity

    @ContributesAndroidInjector
    abstract fun injectUserCenterActivity(): UserCenterActivity

    @ContributesAndroidInjector
    abstract fun injectUserHeadActivity(): UserHeadActivity

    @ContributesAndroidInjector
    abstract fun injectSetTextActivity(): SetTextActivity

    @ContributesAndroidInjector
    abstract fun injectIntroActivity(): IntroActivity

    @ContributesAndroidInjector
    abstract fun injectSettingActivity(): SettingActivity




}