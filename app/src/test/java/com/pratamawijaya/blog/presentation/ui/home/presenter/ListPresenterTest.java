package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.data.model.PostModel;
import com.pratamawijaya.blog.data.model.mapper.PostModelMapper;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArcticleView;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;

import static org.mockito.Matchers.any;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */
public class ListPresenterTest {

  @Mock GetBlogPosts getPosts;
  @Mock PostModelMapper postModelMapper;
  @Mock ListArcticleView view;
  @Mock List<PostModel> postModels;
  @Mock List<Post> posts;

  ListPresenter presenter;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    presenter = Mockito.spy(new ListPresenter(getPosts));

    presenter.attachView(view);
  }

  @Test public void testOnDestroy() throws Exception {
    presenter.detachView();
    Mockito.verify(getPosts).unsubscribe();
  }

  @Test public void testWhenEmptyShouldLoadData() throws Exception {
    Mockito.when(postModels.isEmpty()).thenReturn(true);
    presenter.getPosts(1, true);
    Mockito.verify(view).showLoading();
    Mockito.verify(getPosts).execute(any(Subscriber.class));
  }

  @Test public void testShowResultInRecyclerView() throws Exception {
    List<Post> result = Mockito.mock(List.class);
    Mockito.when(postModelMapper.transform(postModels)).thenReturn(result);

    presenter.getPosts(1, true);

    Mockito.verify(postModelMapper).transform(postModels);
    Mockito.verify(view).setData(result);
  }
}