package com.pratamawijaya.blog.app.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by pratama on 9/30/16.
 */

public interface ActivityHierarchyServer extends Application.ActivityLifecycleCallbacks {
  ActivityHierarchyServer NONE = new ActivityHierarchyServer() {
    @Override public void onActivityCreated(Activity activity, Bundle bundle) {
      // to be empty
    }

    @Override public void onActivityStarted(Activity activity) {
      // to be empty
    }

    @Override public void onActivityResumed(Activity activity) {
      // to be empty
    }

    @Override public void onActivityPaused(Activity activity) {
      // to be empty
    }

    @Override public void onActivityStopped(Activity activity) {
      // to be empty
    }

    @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
      // to be empty
    }

    @Override public void onActivityDestroyed(Activity activity) {
      // to be empty
    }
  };
}
