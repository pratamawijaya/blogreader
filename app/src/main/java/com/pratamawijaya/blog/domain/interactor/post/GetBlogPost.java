package com.pratamawijaya.blog.domain.interactor.post;

import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.interactor.UseCase;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class GetBlogPost extends UseCase {
  private PostRepository repository;
  private boolean isUpdate;
  private int postID;

  @Inject public GetBlogPost(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      PostRepository repository) {
    super(threadExecutor, postExecutionThread);
    this.repository = repository;
  }

  public void setUpdate(boolean update) {
    isUpdate = update;
  }

  public void setPostID(int postID) {
    this.postID = postID;
  }

  @Override protected Observable buildObservableUseCase() {
    return repository.getPost(postID, isUpdate);
  }
}
