package com.pratamawijaya.blog.app.config;

import android.app.Application;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by pratama on 9/30/16.
 */

public class MainInitializer extends ReleaseInitializer {
  protected final Application application;
  private final ActivityHierarchyServer activityHierarchyServer;

  @Inject public MainInitializer(final Timber.Tree logTree, final Application application,
      final ActivityHierarchyServer activityHierarchyServer) {
    super(logTree);
    this.application = application;
    this.activityHierarchyServer = activityHierarchyServer;
  }

  @Override public void initialize() {
    super.initialize();
    initializeActivityLifeCycle();
  }

  private void initializeActivityLifeCycle() {
    application.registerActivityLifecycleCallbacks(activityHierarchyServer);
  }
}
