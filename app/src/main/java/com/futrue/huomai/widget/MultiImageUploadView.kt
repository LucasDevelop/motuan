package com.futrue.huomai.widget

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.AttributeSet
import android.widget.LinearLayout
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback
import com.chad.library.adapter.base.listener.OnItemDragListener
import com.futrue.frame.widget.GridDividerItemDecoration
import com.futrue.huomai.R
import com.futrue.huomai.utils.ImageUtil
import com.futrue.huomai.widget.adapter.MultiImageUploadAdapter
import com.futrue.huomai.window.TakePhotoWindow
import org.devio.takephoto.model.TResult
import java.util.*


/**
 * @package    com.zhongde.haokuai.widget
 * @anthor     luan
 * @date       2019/3/12
 * @des        多图片上传回显
 */
class MultiImageUploadView : LinearLayout, OnItemDragListener {


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
        defStyleAttr) {
        initView(context)
    }

    private var spacing = 20.0
    //列数
    var row = 4
    //最大上传数
    var maxPic = 3
    //最小上传数
    var minPic = 0
    private lateinit var adapter: MultiImageUploadAdapter

    private var imageData = LinkedList<MultiImageUploadAdapter.ImageBean>()
    var takePhotoWindow: TakePhotoWindow? = null

    private fun initView(context: Context) {
        adapter = MultiImageUploadAdapter(R.layout.widget_item_multi_upload)
        val recyclerView = RecyclerView(context)
        addView(recyclerView)
        val layoutManager = GridLayoutManager(context, row)
        recyclerView.layoutManager = layoutManager as RecyclerView.LayoutManager?
        recyclerView.adapter = adapter
        val screenWidth = ScreenUtils.getScreenWidth() //屏幕宽度
        val itemWidth = SizeUtils.dp2px(spacing.toFloat()) //每个item的宽度
//        recyclerView.addItemDecoration(SpaceItemDecoration((screenWidth - itemWidth * 3) / 6))
        recyclerView.addItemDecoration(
            GridDividerItemDecoration(SizeUtils.dp2px(2f),
                GridDividerItemDecoration.GRIDLAYOUT)
        )

        val mItemDragAndSwipeCallback = ItemDragAndSwipeCallback(adapter)
        val mItemTouchHelper = ItemTouchHelper(mItemDragAndSwipeCallback)
        mItemTouchHelper.attachToRecyclerView(recyclerView)

        mItemDragAndSwipeCallback.setDragMoveFlags(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper
                .UP or ItemTouchHelper.DOWN
        )
//        mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        adapter.enableDragItem(mItemTouchHelper)
        adapter.setToggleViewId(R.id.v_icon)
        adapter.setOnItemDragListener(this)


        imageData.add(MultiImageUploadAdapter.ImageBean().apply { isAddView = true })
        adapter.setNewData(imageData)
//        adapter.setOnItemClickListener { adapter, _, position ->
//            if (position == imageData.size - 1 && imageData.size - 1 == maxPic) {
//                ToastUtils.showShort("最多上传${maxPic}张图片")
//                return@setOnItemClickListener
//            }
//            if (takePhotoWindow == null) {
//                throw RuntimeException("未调用setTakePhotoWindow或者takePhotoWindow=null")
//            }
//
//            if ((adapter.data[position] as MultiImageUploadAdapter.ImageBean).isAddView) {
//                takePhotoWindow?.maxPic = maxPic - imageData.size + 1
//                //添加图片
//                takePhotoWindow?.show()
//            } else {
//                if (takePhotoWindow != null && imageData[position].originalPath != null) {
////                    ReViewImgActivity.launch(takePhotoWindow!!.activity, imageData[position].imgPath!!)
//                }
//            }
//        }
        adapter.setOnItemChildClickListener { adapter, view, position ->
            if (view.id == R.id.tv) {
                if (position == imageData.size - 1 && imageData.size - 1 == maxPic) {
                    ToastUtils.showShort("最多上传${maxPic}张图片")
                    return@setOnItemChildClickListener
                }
                if (takePhotoWindow == null) {
                    throw RuntimeException("未调用setTakePhotoWindow或者takePhotoWindow=null")
                }

                if ((adapter.data[position] as MultiImageUploadAdapter.ImageBean).isAddView) {
                    takePhotoWindow?.maxPic = maxPic - imageData.size + 1
                    //添加图片
                    takePhotoWindow?.show()
                } else {
                    if (takePhotoWindow != null && imageData[position].originalPath != null) {
//                    ReViewImgActivity.launch(takePhotoWindow!!.activity, imageData[position].imgPath!!)
                    }
                }
            }
        }

    }

    //获取选择后的图片地址
    fun getSelectImgs(): List<MultiImageUploadAdapter.ImageBean> {
        return adapter.data.filter { !it.isAddView }
    }

    fun takeSuccess(result: TResult) {
        imageData = LinkedList(imageData.filter { !it.isAddView })
        result.images.forEach {
            imageData.add(MultiImageUploadAdapter.ImageBean().apply {
                compressPath = it.compressPath
                originalPath = it.originalPath
            })
        }
        //让添加图片的item始终显示在最后一个
        imageData.add(MultiImageUploadAdapter.ImageBean().apply { isAddView = true })
        adapter.setNewData(imageData)
    }

    fun takeSuccess(result: List<String>) {
        imageData = LinkedList(imageData.filter { !it.isAddView })
        result.forEach {
            imageData.add(MultiImageUploadAdapter.ImageBean().apply {
                val url = ImageUtil.getImgUrl(it)
                compressPath = url
                originalPath = url
            })
        }
        //让添加图片的item始终显示在最后一个
        imageData.add(MultiImageUploadAdapter.ImageBean().apply { isAddView = true })
        adapter.setNewData(imageData)
    }

    fun takeFail(result: TResult, msg: String) {
    }

    fun takeCancel() {
    }

    private var startIndex = 0

    override fun onItemDragMoving(
        source: RecyclerView.ViewHolder?,
        from: Int,
        target: RecyclerView.ViewHolder?,
        to: Int
    ) {
        startIndex = to
    }

    override fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {}

    override fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
        imageData.add(pos, imageData[startIndex])
        imageData.removeAt(startIndex)
    }

}