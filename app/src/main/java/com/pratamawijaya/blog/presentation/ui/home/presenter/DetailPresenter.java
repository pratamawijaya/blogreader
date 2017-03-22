package com.pratamawijaya.blog.presentation.ui.home.presenter;

import android.support.annotation.VisibleForTesting;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPost;
import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.fragment.detail.DetailArticleView;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class DetailPresenter extends BasePresenter<DetailArticleView> {

  private final GetBlogPost getBlogPost;

  @VisibleForTesting public Post post;

  @Inject public DetailPresenter(GetBlogPost getBlogPost) {
    this.getBlogPost = getBlogPost;
  }

  @Override public void attachView(DetailArticleView mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    getBlogPost.dispose();
  }

  public void getDetailPost(int postId, boolean isUpdate) {
    getMvpView().showLoading();
    getBlogPost.execute(new DisposableObserver<Post>() {
      @Override public void onNext(Post value) {
        getMvpView().hideLoading();
        getMvpView().setData(post);
      }

      @Override public void onError(Throwable e) {
        Timber.e("onError() :  %s", e.getLocalizedMessage());
      }

      @Override public void onComplete() {

      }
    }, new GetBlogPost.Param(postId, isUpdate));
  }
}
