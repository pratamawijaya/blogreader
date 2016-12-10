package com.pratamawijaya.blog.presentation.ui.home.fragment.list;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.presentation.base.BaseMvpView;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public interface ListArcticleView extends BaseMvpView {
  void setData(List<Post> posts);
}
