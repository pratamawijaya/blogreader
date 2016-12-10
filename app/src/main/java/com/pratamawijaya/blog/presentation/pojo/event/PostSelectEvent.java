package com.pratamawijaya.blog.presentation.pojo.event;

import com.pratamawijaya.blog.domain.entity.Post;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class PostSelectEvent {
  public Post post;

  public PostSelectEvent(Post post) {
    this.post = post;
  }
}
