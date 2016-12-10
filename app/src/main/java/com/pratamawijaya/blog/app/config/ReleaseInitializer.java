package com.pratamawijaya.blog.app.config;

import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by pratama on 9/30/16.
 */

public class ReleaseInitializer implements Initializer {
  private final Timber.Tree logTree;

  @Inject public ReleaseInitializer(final Timber.Tree logTree) {
    this.logTree = logTree;
  }

  @Override public void initialize() {
    initializeLog();
  }

  private void initializeLog() {
    Timber.plant(logTree);
  }
}
