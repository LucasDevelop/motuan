package com.futrue.huomai.utils;

import android.graphics.Rect;
import android.os.Parcel;
import android.support.annotation.Nullable;

import com.previewlibrary.enitity.IThumbViewInfo;

public class ImageListBean implements IThumbViewInfo {
    public String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Rect getBounds() {
        //        return new Rect();
        return null;
    }

    @Nullable
    @Override
    public String getVideoUrl() {
        return "";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
    }

    public ImageListBean(String url) {
        this.url = url;
    }

    protected ImageListBean(Parcel in) {
        this.url = in.readString();
    }

    public static final Creator<ImageListBean> CREATOR = new Creator<ImageListBean>() {
        @Override
        public ImageListBean createFromParcel(Parcel source) {
            return new ImageListBean(source);
        }

        @Override
        public ImageListBean[] newArray(int size) {
            return new ImageListBean[size];
        }
    };
}

