package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.model.pojo.Post;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/**
 * Created by pratama on 4/11/16.
 */
public interface CacheProviders {
  @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS) Observable<Reply<List<Post>>> getListPost(
      Observable<List<Post>> data, DynamicKey key, EvictDynamicKey evictDynamicKey);

  @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS) Observable<Reply<Post>> getPost(Observable<Post> data,
      DynamicKey key, EvictDynamicKey evictDynamicKey);
}
