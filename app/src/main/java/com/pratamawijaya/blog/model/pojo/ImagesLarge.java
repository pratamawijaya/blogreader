package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class ImagesLarge implements Parcelable {
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

  public ImagesLarge() {
  }

  protected ImagesLarge(Parcel in) {
    this.url = in.readString();
    this.width = in.readInt();
    this.height = in.readInt();
  }

  public static final Parcelable.Creator<ImagesLarge> CREATOR =
      new Parcelable.Creator<ImagesLarge>() {
        @Override public ImagesLarge createFromParcel(Parcel source) {
          return new ImagesLarge(source);
        }

        @Override public ImagesLarge[] newArray(int size) {
          return new ImagesLarge[size];
        }
      };
}
