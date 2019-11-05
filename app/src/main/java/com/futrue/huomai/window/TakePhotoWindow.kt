package com.futrue.huomai.window

import android.Manifest
import android.net.Uri
import android.support.v4.app.FragmentActivity
import android.view.WindowManager
import com.futrue.frame.base.dialog.BaseDialog
import com.futrue.frame.config.FrameInitConfig
import com.futrue.huomai.R
import com.yanzhenjie.permission.Action
import com.yanzhenjie.permission.AndPermission
import kotlinx.android.synthetic.main.window_take_photo.*
import org.devio.takephoto.app.TakePhoto
import org.devio.takephoto.compress.CompressConfig
import org.devio.takephoto.model.CropOptions
import org.devio.takephoto.model.TakePhotoOptions
import java.io.File


/**
 * @package    com.zhongde.haokuai.window
 * @anthor     luan
 * @date       2019/3/9
 * @des        仿iOS选择图片
 */
class TakePhotoWindow(val activity: FragmentActivity, val takePhoto: TakePhoto) : BaseDialog(activity) {

    var maxPic = 1
    override fun initView() {

        v_cancel.setOnClickListener { dismiss() }

        v_capture.setOnClickListener {
            configCompress(takePhoto)
            val (cropOptions, file) = getCropConfig()
            requestPermission {
                //拍照
                if (!file.parentFile.exists()) {
                    file.parentFile.mkdirs()
                }
                takePhoto.onPickFromCapture(Uri.fromFile(file))
            }
            dismiss()
        }
        v_gallery.setOnClickListener {
            configCompress(takePhoto)
//            val (cropOptions, file) = getCropConfig()
            requestPermission {
                //从相册选择
//                if (maxPic == 1)
//                    takePhoto.onPickFromGallery()
//                else
                    takePhoto.onPickMultiple(maxPic)
            }
            dismiss()
        }
    }

    private fun getCropConfig(): Pair<CropOptions, File> {
        //裁剪配置
        val cropOptions = CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create()
        val file = File("${FrameInitConfig.CAMERA_PIC_URI}/img/${System.currentTimeMillis()}.jpg")
        return Pair(cropOptions, file)
    }

    private fun requestPermission(success: () -> Unit) {
        AndPermission.with(activity)
                .runtime()
                .permission(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onGranted {
                    success()
                }.onDenied(Action<List<String>> { data ->
                    "权限被拒绝".showToast()
                }).start()
    }

    override fun resetHeight(): Int = WindowManager.LayoutParams.MATCH_PARENT
    override fun resetWidth(): Int = WindowManager.LayoutParams.MATCH_PARENT

    override fun getLayoutID(): Int? = R.layout.window_take_photo

    private fun configCompress(takePhoto: TakePhoto) {
        //设置图片压缩
        val compressConfig = CompressConfig.Builder()
                .setMaxSize(512 * 1024)
                .setMaxPixel(3000)
                .create()
        takePhoto.onEnableCompress(compressConfig, true)

        val builder = TakePhotoOptions.Builder()
        builder.setCorrectImage(true)
        takePhoto.setTakePhotoOptions(builder.create())
    }
}