package com.pratamawijaya.blog.data.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class PostModel {
  public int id;
  public String type;
  public String slug;
  public String url;
  public String title;
  public String content;
  public String excerpt;
  public Date date;
  public Date modified;
  public List<CategoryModel> categories;
  public AuthorModel author;
  public List<AttachmentModel> attachments;
}
