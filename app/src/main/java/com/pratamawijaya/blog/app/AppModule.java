package com.pratamawijaya.blog.app;

import android.app.Application;
import android.support.annotation.NonNull;
import com.pratamawijaya.blog.data.executor.JobExecutor;
import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.domain.executor.UIThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by pratama on 9/30/16.
 */

@Module @Singleton public class AppModule {
  Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @NonNull @Singleton public Application providesApplication() {
    return application;
  }

  @Provides @Singleton @NonNull
  public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton @NonNull
  public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }
}
