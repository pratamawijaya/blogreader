package com.pratamawijaya.blog.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class Post implements Parcelable {
  public int id;
  public String type;
  public String slug;
  public String url;
  public String title;
  public String content;
  public String excerpt;
  public DateTime date;
  public DateTime modified;
  public List<Category> categories;
  public Author author;
  public List<Attachment> attachments;

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
    dest.writeSerializable(this.date);
    dest.writeSerializable(this.modified);
    dest.writeList(this.categories);
    dest.writeParcelable(this.author, flags);
    dest.writeList(this.attachments);
  }

  public Post() {
  }

  protected Post(Parcel in) {
    this.id = in.readInt();
    this.type = in.readString();
    this.slug = in.readString();
    this.url = in.readString();
    this.title = in.readString();
    this.content = in.readString();
    this.excerpt = in.readString();
    this.date = (DateTime) in.readSerializable();
    this.modified = (DateTime) in.readSerializable();
    this.categories = new ArrayList<Category>();
    in.readList(this.categories, Category.class.getClassLoader());
    this.author = in.readParcelable(Author.class.getClassLoader());
    this.attachments = new ArrayList<Attachment>();
    in.readList(this.attachments, Attachment.class.getClassLoader());
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
