package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArcticleView;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pratama
 * Date : Mar - 3/22/17
 * Project Name : blogreader
 */
@RunWith(MockitoJUnitRunner.class) public class ListPresenterTest {

  @Mock private GetBlogPosts getBlogPosts;
  @Mock private ListArcticleView view;
  @Mock private List<Post> posts;

  private ListPresenter presenter;

  @Before public void setUp() throws Exception {
    presenter = new ListPresenter(getBlogPosts);
    presenter.attachView(view);
    presenter.blogPosts = posts;
  }

  @Test public void testPresenterOnStop() throws Exception {
    presenter.detachView();
    verify(getBlogPosts).dispose();
  }

  @Test public void loadPost_shouldloaddata_when_empty() throws Exception {
    when(posts.isEmpty()).thenReturn(true);
    presenter.loadPosts(1, true);
    verify(view).showLoading();
    verify(getBlogPosts).execute(any(DisposableObserver.class), any(GetBlogPosts.Param.class));
  }

  @Test public void loadPost_displayarticle_whenpostnotempty() throws Exception {
    when(posts.isEmpty()).thenReturn(false);
    presenter.loadPosts(1, true);
    verify(view).displayArticle(posts);
  }

  @Test public void doRefreshTest() throws Exception {
    presenter.doRefresh();
    verify(getBlogPosts).execute(any(DisposableObserver.class), any(GetBlogPosts.Param.class));
  }
}