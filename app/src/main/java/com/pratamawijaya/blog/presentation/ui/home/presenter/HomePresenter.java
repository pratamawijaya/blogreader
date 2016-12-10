package com.pratamawijaya.blog.presentation.ui.home.presenter;

import com.pratamawijaya.blog.presentation.base.BasePresenter;
import com.pratamawijaya.blog.presentation.ui.home.HomeView;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class HomePresenter extends BasePresenter<HomeView> {

  private CompositeSubscription compositeSubscription;

  @Override public void attachView(HomeView mvpView) {
    super.attachView(mvpView);
    compositeSubscription = new CompositeSubscription();
  }

  @Override public void detachView() {
    super.detachView();
    if (compositeSubscription != null) {
      compositeSubscription.unsubscribe();
    }
  }
}
