package com.pratamawijaya.blog.presentation.ui.home.fragment.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.app.AppComponent;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.presentation.BaseFragment;
import com.pratamawijaya.blog.presentation.pojo.event.ShowMessageEvent;
import com.pratamawijaya.blog.presentation.ui.home.di.DaggerHomeComponent;
import com.pratamawijaya.blog.presentation.ui.home.di.HomeModule;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.adapter.ListArticleAdapter;
import com.pratamawijaya.blog.presentation.ui.home.presenter.ListPresenter;
import com.pratamawijaya.blog.presentation.utils.SimpleDividerItemDecoration;
import com.pratamawijaya.blog.utils.EndlessRecyclerOnScrollListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListArticleFragment extends BaseFragment implements ListArcticleView {

  @Bind(R.id.contentView) SwipeRefreshLayout contentView;
  @Bind(R.id.errorView) TextView errorView;
  @Bind(R.id.rvListArctile) RecyclerView recyclerView;

  @Inject ListPresenter presenter;

  private ListArticleAdapter adapter;
  private List<Post> posts;
  private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;

  public ListArticleFragment() {
    // Required empty public constructor
  }

  public static ListArticleFragment newInstance() {
    Bundle args = new Bundle();
    ListArticleFragment fragment = new ListArticleFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_list_article, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    presenter.attachView(this);

    setupRecyclerView();

    presenter.getPosts(1, false);
  }

  private void setupRecyclerView() {
    posts = new ArrayList<>();
    adapter = new ListArticleAdapter(posts, getActivity());
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(adapter);
    recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
        ContextCompat.getDrawable(getActivity(), R.drawable.line_divider)));

    endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(linearLayoutManager) {
      @Override public void onLoadMore(int current_page) {
        presenter.getPosts(current_page, false);
      }
    };

    recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
  }

  @Override public void showLoading() {
    contentView.setRefreshing(true);
  }

  @Override public void hideLoading() {
    contentView.setRefreshing(false);
  }

  @Override public void showMessage(String msg) {
    EventBus.getDefault().post(new ShowMessageEvent.Builder().message(msg).build());
  }

  @Override protected void buildComponent(AppComponent appComponent) {
    DaggerHomeComponent.builder()
        .appComponent(appComponent)
        .homeModule(new HomeModule(getActivity()))
        .build()
        .inject(this);
  }

  @Override public void setData(List<Post> posts) {
    this.posts.addAll(posts);
    adapter.notifyDataSetChanged();
  }
}
