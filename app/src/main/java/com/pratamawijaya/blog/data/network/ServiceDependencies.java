package com.pratamawijaya.blog.data.network;

/**
 * Created by pratama on 9/30/16.
 */

import com.pratamawijaya.blog.data.feature.post.PostServices;

/**
 * list of all services for feature
 */
public interface ServiceDependencies {
  PostServices postServices();
}
