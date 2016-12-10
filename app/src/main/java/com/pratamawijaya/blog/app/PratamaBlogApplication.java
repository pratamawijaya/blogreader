package com.pratamawijaya.blog.app;

import android.app.Application;
import android.content.Context;
import com.pratamawijaya.blog.BuildConfig;
import com.pratamawijaya.blog.app.config.Initializer;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class PratamaBlogApplication extends Application {

  @Inject Initializer initializer;

  protected AppComponent appComponent;

  public AppComponent getAppComponent() {
    return appComponent;
  }

  @Override public void onCreate() {
    super.onCreate();
    setupTimber();

    initializeDaggerComponent();
  }

  private void initializeDaggerComponent() {
    appComponent = buildComponent();
    appComponent.inject(this);
  }

  private AppComponent buildComponent() {
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    return appComponent;
  }

  private void setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  public static PratamaBlogApplication get(Context context) {
    return (PratamaBlogApplication) context.getApplicationContext();
  }
}
