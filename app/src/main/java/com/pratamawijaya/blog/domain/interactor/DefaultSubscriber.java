package com.pratamawijaya.blog.domain.interactor;

/**
 * Created by pratama on 9/30/16.
 */

import rx.Subscriber;

/**
 * Default subscriber BaseActivity class to be used whenever you want default error handling.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {
  @Override public void onCompleted() {

  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onNext(T t) {

  }
}
