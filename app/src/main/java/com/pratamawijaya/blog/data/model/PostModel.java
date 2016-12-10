package com.pratamawijaya.blog.data.model;

import java.util.List;
import org.joda.time.DateTime;

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
  public DateTime date;
  public DateTime modified;
  public List<CategoryModel> categories;
  public AuthorModel author;
  public List<AttachmentModel> attachments;
}
