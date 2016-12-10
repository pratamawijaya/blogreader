package com.pratamawijaya.blog.presentation.ui.home.fragment.detail;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.presentation.base.BaseMvpView;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public interface DetailArticleView extends BaseMvpView {
  void setData(Post post);
}
