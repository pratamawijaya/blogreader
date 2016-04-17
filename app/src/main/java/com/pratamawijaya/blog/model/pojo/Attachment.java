package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class Attachment implements Parcelable {
  public int id;
  public String url;
  public String slug;
  public String title;
  public String description;
  public String caption;
  public int parent;
  public String mime_type;
  public Images images;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.url);
    dest.writeString(this.slug);
    dest.writeString(this.title);
    dest.writeString(this.description);
    dest.writeString(this.caption);
    dest.writeInt(this.parent);
    dest.writeString(this.mime_type);
    dest.writeParcelable(this.images, flags);
  }

  public Attachment() {
  }

  protected Attachment(Parcel in) {
    this.id = in.readInt();
    this.url = in.readString();
    this.slug = in.readString();
    this.title = in.readString();
    this.description = in.readString();
    this.caption = in.readString();
    this.parent = in.readInt();
    this.mime_type = in.readString();
    this.images = in.readParcelable(Images.class.getClassLoader());
  }

  public static final Parcelable.Creator<Attachment> CREATOR =
      new Parcelable.Creator<Attachment>() {
        @Override public Attachment createFromParcel(Parcel source) {
          return new Attachment(source);
        }

        @Override public Attachment[] newArray(int size) {
          return new Attachment[size];
        }
      };
}
