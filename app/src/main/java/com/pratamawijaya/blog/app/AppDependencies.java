package com.pratamawijaya.blog.app;

import android.app.Application;
import com.pratamawijaya.blog.data.network.ServiceDependencies;
import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import com.pratamawijaya.blog.presentation.di.UIDependencies;

/**
 * Created by pratama on 9/30/16.
 */

public interface AppDependencies extends ServiceDependencies, UIDependencies {
  Application application();

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();
}
