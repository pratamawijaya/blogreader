package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.DefaultSubscriber;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPost;
import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.fragment.detail.DetailArticleView;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class DetailPresenter extends BasePresenter<DetailArticleView> {

  private final GetBlogPost getBlogPost;

  @Inject public DetailPresenter(GetBlogPost getBlogPost) {
    this.getBlogPost = getBlogPost;
  }

  @Override public void attachView(DetailArticleView mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    getBlogPost.unsubscribe();
  }

  public void getDetailPost(int postId, boolean isUpdate) {
    getMvpView().showLoading();
    getBlogPost.setPostID(postId);
    getBlogPost.setUpdate(isUpdate);
    getBlogPost.execute(new PostSubscriber());
  }

  public final class PostSubscriber extends DefaultSubscriber<Post> {
    @Override public void onNext(Post post) {
      super.onNext(post);
      getMvpView().hideLoading();
      getMvpView().setData(post);
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
      getMvpView().hideLoading();
      Timber.e("onError() :  %s", e.getLocalizedMessage());
    }

    @Override public void onCompleted() {
      super.onCompleted();
      getMvpView().hideLoading();
    }
  }
}
