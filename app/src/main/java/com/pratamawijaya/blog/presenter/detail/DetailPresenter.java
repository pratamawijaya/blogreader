package com.pratamawijaya.blog.presenter.detail;

import com.pratamawijaya.blog.base.BasePresenter;
import com.pratamawijaya.blog.data.DataManager;
import com.pratamawijaya.blog.ui.detail.DetailArticleInterface;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by pratama on 4/17/16.
 */
public class DetailPresenter extends BasePresenter<DetailArticleInterface> {
  private final DataManager dataManager;
  private CompositeSubscription compositeSubscription = new CompositeSubscription();

  @Inject public DetailPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  @Override public void attachView(DetailArticleInterface mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    if (compositeSubscription != null) {
      compositeSubscription.unsubscribe();
    }
  }

  public void getArticleDetail(final int id, final boolean isUpdate) {
    checkViewAttached();
    compositeSubscription.add(dataManager.getPost(id, isUpdate)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(post -> {
          if (post != null) {
            getMvpView().setData(post);
          }
        }, throwable -> {
          Timber.e("getArticleDetail() :  %s", throwable.getLocalizedMessage());
        }));
  }
}
