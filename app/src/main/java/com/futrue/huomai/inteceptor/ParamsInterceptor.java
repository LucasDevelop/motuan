package com.futrue.huomai.inteceptor;


import android.text.TextUtils;

import com.futrue.huomai.App;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @项目名： Ucella
 * @包名： com.enchantin.ucella.app.clienthelp
 * @创建者： haidev
 * @创建时间： 2017/3/2 0002 下午 5:16
 * @公司： Enchantin
 * @邮箱： haidev.tang@enchantin.com
 * @描述 ：   统一添加公共参数 user_id sign
 */
public class ParamsInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request oldRequest = chain.request();

        // 添加公共参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
        String userId = App.Companion.getInstance().userInfo.getId();

        if (oldRequest.method().equals("GET")) {
            String needUserId = oldRequest.header("needUserId");
            if (!TextUtils.isEmpty(needUserId) && needUserId.equals("false")) {

            } else {
                if (!TextUtils.isEmpty(userId)) {
                    authorizedUrlBuilder.addQueryParameter("user_id", userId);
                }

            }

        } else if (oldRequest.method().equals("POST")) {
            if (oldRequest.body() == null || oldRequest.body() instanceof FormBody) {
                String needUserId = oldRequest.header("needUserId");
                if (!TextUtils.isEmpty(needUserId) && needUserId.equals("false")) {

                } else {
                    FormBody.Builder bodyBuilder = new FormBody.Builder();
                    if (!TextUtils.isEmpty(userId)) {
                        bodyBuilder.add("user_id", userId);
                    }

                    FormBody body;
                    if (oldRequest.body() != null) {
                        body = (FormBody) oldRequest.body();
                        for (int i = 0; i < body.size(); i++) {
                            bodyBuilder.add(body.name(i), body.value(i));
                        }
                    }
                    body = bodyBuilder.build();

                    oldRequest = oldRequest.newBuilder().post(body).build();
                }
            }
        }
        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .removeHeader("needUserId")
                .build();

        return chain.proceed(newRequest);


    }

}
