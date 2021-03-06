package com.pratamawijaya.blog.data.feature.post;

import com.pratamawijaya.blog.data.model.PostModel;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.LifeCache;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public interface PostCacheProviders {
  @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS) Observable<List<PostModel>> getPosts(
      Observable<List<PostModel>> posts, DynamicKey page, EvictDynamicKey evictDynamicKey);

  @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS) Observable<PostModel> getPost(
      Observable<PostModel> post, DynamicKey postID, EvictDynamicKey evictDynamicKey);
}
