package com.pratamawijaya.blog.domain.interactor.post;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.interactor.UseCase;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class GetBlogPosts extends UseCase<List<Post>> {

  private PostRepository repository;
  private boolean isUpdate;
  private int page;

  @Inject
  public GetBlogPosts(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      PostRepository repository) {
    super(threadExecutor, postExecutionThread);
    this.repository = repository;
  }

  public void setUpdate(boolean update) {
    isUpdate = update;
  }

  public void setPage(int page) {
    this.page = page;
  }

  @Override protected Observable buildObservableUseCase() {
    return repository.getPosts(page, isUpdate);
  }
}
