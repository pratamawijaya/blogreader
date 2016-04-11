package com.pratamawijaya.blog.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.base.BaseActivity;
import com.pratamawijaya.blog.model.pojo.Post;
import com.pratamawijaya.blog.presenter.home.HomeViewPresenter;
import com.pratamawijaya.blog.utils.EndlessRecyclerOnScrollListener;
import java.util.List;
import javax.inject.Inject;

public class HomeViewActivity extends BaseActivity
    implements HomeViewInterface, SwipeRefreshLayout.OnRefreshListener {

  @Bind(R.id.content_view) SwipeRefreshLayout contentView;
  @Bind(R.id.recycler_view) RecyclerView recyclerView;
  @Bind(R.id.loading_view) ProgressBar loadingView;

  @Inject HomeViewPresenter presenter;
  private HomeViewAdapter adapter;
  private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
  private LinearLayoutManager linearLayoutManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    getSupportActionBar().setTitle("Home");

    presenter.attachView(this);
    presenter.getArticle(1, false);

    setupRecyclerView();
    contentView.setOnRefreshListener(this);
  }

  private void setupRecyclerView() {
    linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);
    adapter = new HomeViewAdapter(this);

    endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(linearLayoutManager) {
      @Override public void onLoadMore(int current_page) {
        presenter.getArticle(current_page, false);
      }
    };

    recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
    recyclerView.setAdapter(adapter);
  }

  @Override protected void onRestart() {
    super.onRestart();
    endlessRecyclerOnScrollListener.reset(0, true);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  @Override public void showLoading() {
    loadingView.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    loadingView.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
  }

  @Override public void setData(List<Post> listPost) {
    adapter.addPost(listPost);
  }

  @Override public void onRefresh() {

  }
}
