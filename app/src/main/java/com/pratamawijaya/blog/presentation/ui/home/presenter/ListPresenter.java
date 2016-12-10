package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.DefaultSubscriber;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArcticleView;
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

  @Inject public ListPresenter(GetBlogPosts getBlogPosts) {
    this.getBlogPosts = getBlogPosts;
  }

  @Override public void attachView(ListArcticleView mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    getBlogPosts.unsubscribe();
  }

  public void getPosts(int page, boolean isUpdate) {
    getMvpView().showLoading();

    getBlogPosts.setPage(page);
    getBlogPosts.setUpdate(isUpdate);
    getBlogPosts.execute(new PostsSubscriber());
  }

  public final class PostsSubscriber extends DefaultSubscriber<List<Post>> {
    @Override public void onNext(List<Post> posts) {
      super.onNext(posts);
      getMvpView().hideLoading();
      getMvpView().setData(posts);
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
      Timber.e("onError() :  %s", e.getLocalizedMessage());
      getMvpView().hideLoading();
    }

    @Override public void onCompleted() {
      super.onCompleted();
      getMvpView().hideLoading();
    }
  }
}
