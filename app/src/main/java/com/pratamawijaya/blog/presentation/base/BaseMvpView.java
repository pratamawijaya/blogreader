package com.pratamawijaya.blog.presentation.base;

/**
 * Created by pratama on 10/4/16.
 */

public interface BaseMvpView {
  void showLoading();

  void hideLoading();

  void showMessage(String msg);
}
