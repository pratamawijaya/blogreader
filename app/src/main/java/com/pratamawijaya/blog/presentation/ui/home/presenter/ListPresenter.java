package com.pratamawijaya.blog.presentation.ui.home.presenter;

import android.support.annotation.VisibleForTesting;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArcticleView;
import com.pratamawijaya.blog.utils.Lists;
import io.reactivex.observers.DisposableObserver;
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

  @VisibleForTesting public List<Post> blogPosts;

  @Inject public ListPresenter(GetBlogPosts getBlogPosts) {
    this.getBlogPosts = getBlogPosts;
  }

  @Override public void attachView(ListArcticleView mvpView) {
    super.attachView(mvpView);
    blogPosts = new ArrayList<>();
  }

  @Override public void detachView() {
    super.detachView();
    getBlogPosts.dispose();
  }

  public void loadPosts(int page, boolean isUpdate) {
    if (Lists.isEmptyOrNull(blogPosts)) {
      getMvpView().showLoading();

      getBlogPosts.execute(new DisposableObserver<List<Post>>() {
        @Override public void onNext(List<Post> posts) {
          getMvpView().hideLoading();
          if (posts != null && posts.size() > 0) {
            getMvpView().displayArticle(posts);
          } else {
            getMvpView().displayNoArticle();
          }
        }

        @Override public void onError(Throwable e) {
          Timber.e("onError() :  %s", e.getLocalizedMessage());
        }

        @Override public void onComplete() {
          getMvpView().hideLoading();
        }
      }, new GetBlogPosts.Param(page, isUpdate));
    } else {
      getMvpView().displayArticle(blogPosts);
    }
  }

  public void doRefresh() {
    getBlogPosts.execute(new DisposableObserver<List<Post>>() {
      @Override public void onNext(List<Post> posts) {
        getMvpView().hideLoading();
        if (posts != null && posts.size() > 0) {
          getMvpView().displayArticle(posts);
        } else {
          getMvpView().displayNoArticle();
        }
      }

      @Override public void onError(Throwable e) {
        Timber.e("onError() :  %s", e.getLocalizedMessage());
      }

      @Override public void onComplete() {
        getMvpView().hideLoading();
      }
    }, new GetBlogPosts.Param(1, true));
  }
}
