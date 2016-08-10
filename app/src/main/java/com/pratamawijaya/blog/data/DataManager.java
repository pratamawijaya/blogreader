package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.model.pojo.Post;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Singleton public class DataManager {
  private final PratamaService pratamaService;
  private final CacheProviders cacheProviders;

  @Inject public DataManager(CacheProviders cacheProviders, DatabaseHelper databaseHelper,
      PratamaService pratamaService) {
    this.cacheProviders = cacheProviders;
    this.pratamaService = pratamaService;
  }

  /**
   * get post data from local
   *
   * @return List Post
   */
  public Observable<List<Post>> getPosts(final int page, final boolean isUpdate) {
    //return cacheProviders.getListPost(pratamaService.getRecentPost(page)
    //        .flatMap(postResponse -> Observable.just(postResponse.posts)), new DynamicKey(page),
    //    new EvictDynamicKey(isUpdate));
    return pratamaService.getRecentPost(page)
        .flatMap(postResponse -> Observable.just(postResponse.posts));
  }

  public Observable<Post> getPost(final int id, final boolean isUpdate) {
    return pratamaService.getPost(id)
        .flatMap(singlePostResponse -> Observable.just(singlePostResponse.post));
  }
}
