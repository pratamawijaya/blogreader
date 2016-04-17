package com.pratamawijaya.blog.ui.detail;

import com.pratamawijaya.blog.base.MvpView;
import com.pratamawijaya.blog.model.pojo.Post;

/**
 * Created by pratama on 4/17/16.
 */
public interface DetailArticleInterface extends MvpView {
  void setData(Post post);
}
