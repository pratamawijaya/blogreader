package com.pratamawijaya.blog.domain.executor;

/**
 * Created by pratama on 9/30/16.
 */

import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android UI thread
 */
@Singleton public class UIThread implements PostExecutionThread {

  @Inject public UIThread() {
    // to be injection
  }

  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
