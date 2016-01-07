package com.pratamawijaya.blog.ui.home;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.base.BaseActivity;
import com.pratamawijaya.blog.model.pojo.Post;
import com.pratamawijaya.blog.presenter.home.HomeViewPresenter;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class HomeViewActivity extends BaseActivity implements HomeViewInterface {

  private static final String TAG = "HomeViewActivity";

  @Inject HomeViewPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    presenter.attachView(this);
    presenter.getArticle();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void setData(List<Post> listPost) {
    for (Post data : listPost) {
      Timber.d("setData(): " + data.title + " , " + data.date.toString());
    }
  }
}
