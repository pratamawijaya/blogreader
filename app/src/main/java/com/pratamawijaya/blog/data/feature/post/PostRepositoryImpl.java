package com.pratamawijaya.blog.data.feature.post;

import com.pratamawijaya.blog.data.model.mapper.PostModelMapper;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class PostRepositoryImpl implements PostRepository {

  private final PostServices services;
  private final PostCacheProviders cacheProviders;
  private final PostModelMapper mapper;

  @Inject public PostRepositoryImpl(PostServices services, PostCacheProviders cacheProviders,
      PostModelMapper mapper) {
    this.services = services;
    this.cacheProviders = cacheProviders;
    this.mapper = mapper;
  }

  @Override public Observable<List<Post>> getPosts(int page, boolean isUpdate) {
    return cacheProviders.getPosts(
        services.getRecentPosts(page).flatMap(postResponse -> Observable.just(postResponse.posts)),
        new DynamicKey(page), new EvictDynamicKey(isUpdate)).map(this.mapper::transform);
  }

  @Override public Observable<Post> getPost(int postId, boolean isUpdate) {
    return cacheProviders.getPost(
        services.getPost(postId).flatMap(postResponse -> Observable.just(postResponse.post)),
        new DynamicKey(postId), new EvictDynamicKey(isUpdate)).map(this.mapper::transform);
  }
}
