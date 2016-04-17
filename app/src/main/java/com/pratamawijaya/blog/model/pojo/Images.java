package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class Images implements Parcelable {
  public ImagesFull full;
  public ImagesThumbnail thumbnail;
  public ImagesMedium medium;
  public ImagesMediumLarge medium_large;
  public ImagesLarge large;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.full, flags);
    dest.writeParcelable(this.thumbnail, flags);
    dest.writeParcelable(this.medium, flags);
    dest.writeParcelable(this.medium_large, flags);
    dest.writeParcelable(this.large, flags);
  }

  public Images() {
  }

  protected Images(Parcel in) {
    this.full = in.readParcelable(ImagesFull.class.getClassLoader());
    this.thumbnail = in.readParcelable(ImagesThumbnail.class.getClassLoader());
    this.medium = in.readParcelable(ImagesMedium.class.getClassLoader());
    this.medium_large = in.readParcelable(ImagesMediumLarge.class.getClassLoader());
    this.large = in.readParcelable(ImagesLarge.class.getClassLoader());
  }

  public static final Parcelable.Creator<Images> CREATOR = new Parcelable.Creator<Images>() {
    @Override public Images createFromParcel(Parcel source) {
      return new Images(source);
    }

    @Override public Images[] newArray(int size) {
      return new Images[size];
    }
  };
}
