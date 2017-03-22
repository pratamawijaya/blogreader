package com.pratamawijaya.blog.data.feature.post;

import com.pratamawijaya.blog.data.model.mapper.PostModelMapper;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class PostRepositoryImpl implements PostRepository {

  private final PostServices services;
  private final PostModelMapper mapper;

  @Inject public PostRepositoryImpl(PostServices services, PostModelMapper mapper) {
    this.services = services;
    this.mapper = mapper;
  }

  @Override public Observable<List<Post>> getPosts(int page, boolean isUpdate) {
    return services.getRecentPosts(page)
        .flatMap(postsResponse -> Observable.just(postsResponse.posts))
        .map(this.mapper::transform);
  }

  @Override public Observable<Post> getPost(int postId, boolean isUpdate) {
    return services.getPost(postId)
        .flatMap(postResponse -> Observable.just(postResponse.post))
        .map(this.mapper::transform);
  }
}
