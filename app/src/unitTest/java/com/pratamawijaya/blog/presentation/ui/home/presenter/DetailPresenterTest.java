package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPost;
import com.pratamawijaya.blog.presentation.ui.home.fragment.detail.DetailArticleView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rx.Subscriber;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by pratama
 * Date : Mar - 3/22/17
 * Project Name : blogreader
 */
@RunWith(MockitoJUnitRunner.class) public class DetailPresenterTest {

  @Mock private GetBlogPost getBlogPost;
  @Mock private DetailArticleView view;
  @Mock private Post post;

  private DetailPresenter presenter;

  @Before public void setUp() throws Exception {
    presenter = new DetailPresenter(getBlogPost);
    presenter.attachView(view);
    presenter.post = post;
  }

  @Test public void test_onDetachUseCaseMustUnsubscribe() throws Exception {
    presenter.detachView();
    verify(getBlogPost).unsubscribe();
  }

  @Test public void test_loaddata_show_loading() throws Exception {
    presenter.getDetailPost(1, true);
    verify(view).showLoading();
    verify(getBlogPost).execute(any(Subscriber.class));
  }
}