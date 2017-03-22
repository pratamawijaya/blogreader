package com.pratamawijaya.blog.domain.interactor.post;

import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by pratama
 * Date : Mar - 3/23/17
 * Project Name : blogreader
 */
@RunWith(MockitoJUnitRunner.class) public class GetBlogPostTest {

  private GetBlogPost getBlogPost;

  @Mock private ThreadExecutor threadExecutor;
  @Mock private PostExecutionThread postExecutionThread;
  @Mock private PostRepository postRepository;

  @Before public void setUp() throws Exception {
    getBlogPost = new GetBlogPost(threadExecutor, postExecutionThread, postRepository);
  }

  @Test public void testBuildObservableGetBlogPostUseCase() throws Exception {
    getBlogPost.buildUseCaseObservable(new GetBlogPost.Param(1, true));

    verify(postRepository).getPost(1, true);
    verifyNoMoreInteractions(postRepository);
    verifyZeroInteractions(postExecutionThread);
    verifyZeroInteractions(threadExecutor);
  }
}