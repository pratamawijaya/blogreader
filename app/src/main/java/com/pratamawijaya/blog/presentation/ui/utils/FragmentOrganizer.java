package com.pratamawijaya.blog.presentation.ui.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public abstract class FragmentOrganizer {
  protected FragmentManager fragmentManager;
  private int containerResourceId;

  public FragmentOrganizer(FragmentManager fragmentManager, int containerResourceId) {
    this.fragmentManager = fragmentManager;
    this.containerResourceId = containerResourceId;
    openFragment(getInitialFragment());
  }

  protected abstract Fragment getInitialFragment();

  public abstract boolean handleBackNavigation();

  protected Fragment getOpenFragment() {
    String tag =
        fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
    return fragmentManager.findFragmentByTag(tag);
  }

  protected boolean isFragmentOpen(Fragment fragment) {
    return isFragmentOpen(fragment, true);
  }

  protected boolean isFragmentOpen(Fragment fragment, boolean useArgs) {
    String fragmentTag = createFragmentTag(fragment, useArgs);

    if (fragmentManager.getBackStackEntryCount() != 0) {
      String name =
          fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1)
              .getName();

      if (!useArgs) name = name.substring(0, name.indexOf("-"));

      return name.equals(fragmentTag);
    }

    return false;
  }

  private String createFragmentTag(Fragment fragment, boolean addArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(fragment.getClass().getSimpleName());
    if (addArgs) {
      stringBuilder.append("-");
      if (fragment.getArguments() != null) stringBuilder.append(fragment.getArguments().toString());
    }
    return stringBuilder.toString();
  }

  public void openFragment(Fragment fragment) {
    if (isFragmentOpen(fragment)) return;

    String fragmentTag = createFragmentTag(fragment, true);

    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(containerResourceId, fragment, fragmentTag);
    transaction.addToBackStack(fragmentTag).commit();
  }
}
