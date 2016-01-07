package com.pratamawijaya.blog.ui.home;

import com.pratamawijaya.blog.base.MvpView;
import com.pratamawijaya.blog.model.pojo.Post;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public interface HomeViewInterface extends MvpView {
  void showLoading();
  void hideLoading();
  void setData(List<Post> listPost);
}
