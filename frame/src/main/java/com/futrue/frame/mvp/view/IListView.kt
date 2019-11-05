package com.futrue.frame.mvp.view


interface IListView : ISwipeView {
    //加载更多失败
    fun showLoadMoreFailView()

    //加载更多成功
    fun showLoadMoreSuccessView()

    //加载更多错误
    fun showLoadMoreErrorView()
}