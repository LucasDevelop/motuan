package com.futrue.huomai.main.my.findfirend.addressbook

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class AddressBookPresenter @Inject constructor(v: AddressBookFragment, apiServer: ApiServer) :
    BasePresenter<AddressBookFragment>(v, apiServer) {
}

