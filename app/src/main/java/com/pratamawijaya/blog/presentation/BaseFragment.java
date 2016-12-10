package com.pratamawijaya.blog.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.pratamawijaya.blog.app.AppComponent;
import com.pratamawijaya.blog.app.PratamaBlogApplication;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public abstract class BaseFragment extends Fragment {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityComponent();
  }

  protected void setupActivityComponent() {
    buildComponent(PratamaBlogApplication.get(getActivity()).getAppComponent());
  }

  abstract protected void buildComponent(AppComponent appComponent);
}
