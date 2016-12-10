package com.pratamawijaya.blog.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class Post implements Parcelable {
  public int id;
  public String type;
  public String slug;
  public String url;
  public String title;
  public String content;
  public String excerpt;
  public Date date;
  public Date modified;

  public Post(int id) {
    this.id = id;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.type);
    dest.writeString(this.slug);
    dest.writeString(this.url);
    dest.writeString(this.title);
    dest.writeString(this.content);
    dest.writeString(this.excerpt);
    dest.writeLong(this.date != null ? this.date.getTime() : -1);
    dest.writeLong(this.modified != null ? this.modified.getTime() : -1);
  }

  protected Post(Parcel in) {
    this.id = in.readInt();
    this.type = in.readString();
    this.slug = in.readString();
    this.url = in.readString();
    this.title = in.readString();
    this.content = in.readString();
    this.excerpt = in.readString();
    long tmpDate = in.readLong();
    this.date = tmpDate == -1 ? null : new Date(tmpDate);
    long tmpModified = in.readLong();
    this.modified = tmpModified == -1 ? null : new Date(tmpModified);
  }

  public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
    @Override public Post createFromParcel(Parcel source) {
      return new Post(source);
    }

    @Override public Post[] newArray(int size) {
      return new Post[size];
    }
  };
}
