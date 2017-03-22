package com.pratamawijaya.blog.domain.interactor.post;

import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.interactor.UseCase;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class GetBlogPosts extends UseCase<List<Post>, GetBlogPosts.Param> {

  private PostRepository repository;

  @Inject
  public GetBlogPosts(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      PostRepository repository) {
    super(threadExecutor, postExecutionThread);
    this.repository = repository;
  }

  @Override public Observable<List<Post>> buildUseCaseObservable(Param param) {
    return repository.getPosts(param.page, param.isUpdate);
  }

  public static class Param {
    public int page;
    public boolean isUpdate;

    public Param(int page, boolean isUpdate) {
      this.page = page;
      this.isUpdate = isUpdate;
    }
  }
}
