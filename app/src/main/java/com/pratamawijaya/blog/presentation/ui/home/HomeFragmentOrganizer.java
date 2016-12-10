package com.pratamawijaya.blog.presentation.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArticleFragment;
import com.pratamawijaya.blog.presentation.ui.utils.FragmentOrganizer;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class HomeFragmentOrganizer extends FragmentOrganizer {

  public HomeFragmentOrganizer(FragmentManager fragmentManager, int containerResourceId) {
    super(fragmentManager, containerResourceId);
  }

  @Override protected Fragment getInitialFragment() {
    return ListArticleFragment.newInstance();
  }

  @Override public boolean handleBackNavigation() {
    Fragment fragment = getOpenFragment();
    if (fragment instanceof ListArticleFragment) {
      return false;
    } else {
      fragmentManager.popBackStack();
      return true;
    }
  }
}
