package com.pratamawijaya.blog.presentation.ui.home.fragment.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pratamawijaya.blog.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailArticleFragment extends Fragment {

  public DetailArticleFragment() {
    // Required empty public constructor
  }

  public static DetailArticleFragment newInstance() {
    Bundle args = new Bundle();
    DetailArticleFragment fragment = new DetailArticleFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_detail_article, container, false);
  }
}
