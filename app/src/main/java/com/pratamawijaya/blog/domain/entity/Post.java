package com.pratamawijaya.blog.domain.entity;

import org.joda.time.DateTime;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class Post {
  public int id;
  public String type;
  public String slug;
  public String url;
  public String title;
  public String content;
  public String excerpt;
  public DateTime date;
  public DateTime modified;

  public Post(int id) {
    this.id = id;
  }
}
