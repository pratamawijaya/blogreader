package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class ImagesMedium implements Parcelable {
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

  public ImagesMedium() {
  }

  protected ImagesMedium(Parcel in) {
    this.url = in.readString();
    this.width = in.readInt();
    this.height = in.readInt();
  }

  public static final Parcelable.Creator<ImagesMedium> CREATOR =
      new Parcelable.Creator<ImagesMedium>() {
        @Override public ImagesMedium createFromParcel(Parcel source) {
          return new ImagesMedium(source);
        }

        @Override public ImagesMedium[] newArray(int size) {
          return new ImagesMedium[size];
        }
      };
}
