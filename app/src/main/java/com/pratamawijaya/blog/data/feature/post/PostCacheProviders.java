package com.pratamawijaya.blog.data.feature.post;

import com.pratamawijaya.blog.data.model.PostModel;
import io.rx_cache.EvictProvider;
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

  @LifeCache(duration = 1, timeUnit = TimeUnit.HOURS) Observable<List<PostModel>> getPosts(
      Observable<List<PostModel>> posts, EvictProvider evictProvider);
}
