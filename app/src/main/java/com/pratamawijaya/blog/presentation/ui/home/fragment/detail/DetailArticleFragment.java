package com.pratamawijaya.blog.presentation.ui.home.fragment.detail;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.app.AppComponent;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.presentation.BaseFragment;
import com.pratamawijaya.blog.presentation.ui.home.di.DaggerHomeComponent;
import com.pratamawijaya.blog.presentation.ui.home.di.HomeModule;
import com.pratamawijaya.blog.presentation.ui.home.presenter.DetailPresenter;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailArticleFragment extends BaseFragment implements DetailArticleView {

  @Bind(R.id.webviewDetailArticle) WebView webViewDetailArticle;

  @Inject DetailPresenter presenter;

  private Post post;
  private ProgressDialog progressDialog;

  public DetailArticleFragment() {
    // Required empty public constructor
  }

  public static DetailArticleFragment newInstance(Post post) {
    Bundle args = new Bundle();
    args.putParcelable("content", post);
    DetailArticleFragment fragment = new DetailArticleFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    post = getArguments().getParcelable("content");
    progressDialog = new ProgressDialog(getActivity());
    progressDialog.setMessage("Loading...");
  }

  @Override protected void buildComponent(AppComponent appComponent) {
    DaggerHomeComponent.builder()
        .appComponent(appComponent)
        .homeModule(new HomeModule(getActivity()))
        .build()
        .inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_detail_article, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);

    presenter.attachView(this);
    if (post != null) {
      presenter.getDetailPost(post.id, false);
    }
  }

  @Override public void showLoading() {
    progressDialog.show();
  }

  @Override public void hideLoading() {
    progressDialog.dismiss();
  }

  @Override public void showMessage(String msg) {

  }

  @Override public void setData(Post post) {
    webViewDetailArticle.setWebViewClient(new WebViewClient());
    webViewDetailArticle.loadData(post.content, "text/html", "utf-8");
  }
}
