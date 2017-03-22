package com.pratamawijaya.blog.domain.interactor.post;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.interactor.UseCase;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class GetBlogPost extends UseCase<Post, GetBlogPost.Param> {
  private PostRepository repository;

  @Inject public GetBlogPost(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      PostRepository repository) {
    super(threadExecutor, postExecutionThread);
    this.repository = repository;
  }

  @Override public Observable<Post> buildUseCaseObservable(Param param) {
    return repository.getPost(param.postId, param.isUpdate);
  }

  public static class Param {
    public int postId;
    public boolean isUpdate;

    public Param(int postId, boolean isUpdate) {
      this.postId = postId;
      this.isUpdate = isUpdate;
    }
  }
}
