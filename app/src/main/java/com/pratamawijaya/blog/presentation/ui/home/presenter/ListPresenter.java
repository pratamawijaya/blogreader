package com.pratamawijaya.blog.presentation.ui.home.presenter;

import android.support.annotation.VisibleForTesting;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArcticleView;
import com.pratamawijaya.blog.utils.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class ListPresenter extends BasePresenter<ListArcticleView> {

  private final GetBlogPosts getBlogPosts;

  @VisibleForTesting public List<Post> posts;

  @Inject public ListPresenter(GetBlogPosts getBlogPosts) {
    this.getBlogPosts = getBlogPosts;
  }

  @Override public void attachView(ListArcticleView mvpView) {
    super.attachView(mvpView);
    posts = new ArrayList<>();
  }

  @Override public void detachView() {
    super.detachView();
    getBlogPosts.unsubscribe();
  }

  public void loadPosts(int page, boolean isUpdate) {
    if (Lists.isEmptyOrNull(posts)) {
      getMvpView().showLoading();
      getBlogPosts.setPage(page);
      getBlogPosts.setUpdate(isUpdate);
      getBlogPosts.execute(posts -> {
        if (posts != null && posts.size() > 0) {
          this.posts = posts;
          getMvpView().displayArticle(posts);
        } else {
          getMvpView().displayNoArticle();
        }
      }, throwable -> {
        Timber.e("loadPosts() :  %s", throwable.getLocalizedMessage());
      });
    } else {
      getMvpView().displayArticle(posts);
    }
  }

  public void doRefresh() {
    getMvpView().showLoading();
    getBlogPosts.setPage(1);
    getBlogPosts.setUpdate(true);
    getBlogPosts.execute(posts1 -> {
      getMvpView().displayArticle(posts1);
    }, throwable -> {
      Timber.e("doRefresh() :  %s", throwable.getLocalizedMessage());
    });
  }
}
