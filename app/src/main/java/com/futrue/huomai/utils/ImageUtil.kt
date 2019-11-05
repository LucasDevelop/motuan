package com.futrue.huomai.utils

import android.app.Activity
import android.support.v4.app.Fragment
import com.blankj.utilcode.util.EncodeUtils
import com.futrue.frame.config.FrameInitConfig
import com.previewlibrary.GPreviewBuilder
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.File
import java.io.FileInputStream
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


/**
 * @package    com.zhongde.tinglishi.utils
 * @anthor     lucas
 * @date       2018/12/21
 * @des
 */
object ImageUtil {

    //获取完整的图片地址
    fun getImgUrl(path: String): String {
        if (path.contains("http://") || path.contains("https://")) return path
        return FrameInitConfig.BASE_URL + path
    }


    fun preview(context: Activity, data: List<String>, position: Int) {
        val imageData = LinkedList<ImageListBean>()
        data.forEach {
            var url = it
            if (!url.startsWith("http")) {
                url = FrameInitConfig.BASE_URL + url
            }
            imageData.add(ImageListBean(url))
        }
        GPreviewBuilder.from(context)
            .setData(imageData)
            .setCurrentIndex(position)
            .setSingleFling(true)
            .setType(GPreviewBuilder.IndicatorType.Number)
            .start()
    }

    fun preview(context: Fragment, data: List<String>, position: Int) {
        val imageData = LinkedList<ImageListBean>()
        data.forEach {
            var url = it
            if (!url.startsWith("http")) {
                url = FrameInitConfig.BASE_URL + url
            }
            imageData.add(ImageListBean(url))
        }
        GPreviewBuilder.from(context)
            .setData(imageData)
            .setCurrentIndex(position)
            .setSingleFling(true)
            .setType(GPreviewBuilder.IndicatorType.Number)
            .start()
    }

    //文件转base64
    fun fileTransformBase64(file: File): Observable<String> {
        return Observable.just(file)
                .delay(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    val list = ArrayList<Byte>()
                    val stream = FileInputStream(file)
                    val buffer = ByteArray(1024 * 10)
                    while (stream.read(buffer) != -1) {
                        list.addAll(buffer.toList())
                    }
                    stream.close()
                    val base64Decode = EncodeUtils.base64Encode2String(list.toByteArray())
                    "data:image/png;base64,$base64Decode"
                }

    }


    //文件转base64
    fun fileTransformBase64(path: String): Observable<String> {
        return Observable.just(path)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    val list = ArrayList<Byte>()
                    val stream = FileInputStream(path)
                    val buffer = ByteArray(1024 * 10)
                    while (stream.read(buffer) != -1) {
                        list.addAll(buffer.toList())
                    }
                    stream.close()
                    val base64Decode = EncodeUtils.base64Encode2String(list.toByteArray())
                    "data:image/png;base64,$base64Decode"
                }

    }
}