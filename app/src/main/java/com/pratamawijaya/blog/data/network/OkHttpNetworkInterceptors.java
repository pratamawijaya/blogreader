package com.pratamawijaya.blog.data.network;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pratama on 9/30/16.
 */

@Documented @Qualifier @Retention(RUNTIME) public @interface OkHttpNetworkInterceptors {
}
