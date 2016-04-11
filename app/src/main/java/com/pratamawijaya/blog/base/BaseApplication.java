package com.pratamawijaya.blog.base;

import android.app.Application;
import android.content.Context;
import com.pratamawijaya.blog.BuildConfig;
import com.pratamawijaya.blog.injection.component.ApplicationComponent;
import com.pratamawijaya.blog.injection.component.DaggerApplicationComponent;
import com.pratamawijaya.blog.injection.module.ApplicationModule;
import net.danlew.android.joda.JodaTimeAndroid;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class BaseApplication extends Application {

  ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    JodaTimeAndroid.init(this);
    setupTimber();
  }

  private void setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  public ApplicationComponent getApplicationComponent() {
    if (applicationComponent == null) {
      applicationComponent = DaggerApplicationComponent.builder()
          .applicationModule(new ApplicationModule(this))
          .build();
    }
    return applicationComponent;
  }

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }
}
