package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class ImagesFull implements Parcelable {
  public String url;
  public int width;
  public int height;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.url);
    dest.writeInt(this.width);
    dest.writeInt(this.height);
  }

  public ImagesFull() {
  }

  protected ImagesFull(Parcel in) {
    this.url = in.readString();
    this.width = in.readInt();
    this.height = in.readInt();
  }

  public static final Parcelable.Creator<ImagesFull> CREATOR =
      new Parcelable.Creator<ImagesFull>() {
        @Override public ImagesFull createFromParcel(Parcel source) {
          return new ImagesFull(source);
        }

        @Override public ImagesFull[] newArray(int size) {
          return new ImagesFull[size];
        }
      };
}
