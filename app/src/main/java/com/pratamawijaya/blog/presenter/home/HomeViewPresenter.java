package com.pratamawijaya.blog.presenter.home;

import com.pratamawijaya.blog.base.BasePresenter;
import com.pratamawijaya.blog.data.DataManager;
import com.pratamawijaya.blog.ui.home.HomeViewInterface;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class HomeViewPresenter extends BasePresenter<HomeViewInterface> {

  private CompositeSubscription compositeSubscription = new CompositeSubscription();
  private final DataManager dataManager;

  @Inject public HomeViewPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  @Override public void attachView(HomeViewInterface mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    if (compositeSubscription != null) compositeSubscription.unsubscribe();
  }

  public void getArticle(final int page, final boolean isUpdate) {
    checkViewAttached();
    if (page == 1) {
      getMvpView().showLoading();
    }
    compositeSubscription.add(dataManager.getPosts(page, isUpdate)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(posts -> {
          getMvpView().hideLoading();
          if (posts != null && posts.size() > 0) {
            getMvpView().setData(posts);
          }
        }, throwable -> {
          getMvpView().hideLoading();
          Timber.e("getArticle(): " + throwable.getLocalizedMessage());
        }));
  }
}
