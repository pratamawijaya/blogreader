package com.pratamawijaya.blog.presentation.base;

/**
 * Created by pratama on 10/4/16.
 */

public interface Presenter<V extends BaseMvpView> {
  void attachView(V mvpView);

  void detachView();
}
