package com.pratamawijaya.blog.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by pratama on 10/3/16.
 */

@Scope @Retention(RetentionPolicy.RUNTIME) public @interface PerActivity {
}