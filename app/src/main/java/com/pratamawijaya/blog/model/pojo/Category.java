package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class Category implements Parcelable {
  public int id;
  public String slug;
  public String title;
  public String description;
  public int parent;
  public int post_count;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.slug);
    dest.writeString(this.title);
    dest.writeString(this.description);
    dest.writeInt(this.parent);
    dest.writeInt(this.post_count);
  }

  public Category() {
  }

  protected Category(Parcel in) {
    this.id = in.readInt();
    this.slug = in.readString();
    this.title = in.readString();
    this.description = in.readString();
    this.parent = in.readInt();
    this.post_count = in.readInt();
  }

  public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
    @Override public Category createFromParcel(Parcel source) {
      return new Category(source);
    }

    @Override public Category[] newArray(int size) {
      return new Category[size];
    }
  };
}
