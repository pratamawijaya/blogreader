package com.pratamawijaya.blog.app.config;

import android.support.annotation.NonNull;
import com.pratamawijaya.blog.data.network.OkHttpInterceptors;
import com.pratamawijaya.blog.data.network.OkHttpNetworkInterceptors;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

import static java.util.Collections.emptyList;

/**
 * Created by pratama on 9/30/16.
 */

@Module public class SupportModule {
  @Provides @Singleton @NonNull public ActivityHierarchyServer provideActivityHierarchyServer() {
    return ActivityHierarchyServer.NONE;
  }

  @Provides @Singleton @NonNull public Timber.Tree provideTimber() {
    return new Timber.DebugTree();
  }

  @Provides @Singleton @NonNull public Initializer provideInitializer(MainInitializer initializer) {
    return initializer;
  }

  @Provides @OkHttpInterceptors @Singleton @NonNull
  public List<Interceptor> provideOkHttpInterceptors() {
    List<Interceptor> interceptorList = new ArrayList<>();
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    interceptorList.add(httpLoggingInterceptor);
    return interceptorList;
  }

  @Provides @OkHttpNetworkInterceptors @Singleton @NonNull
  public List<Interceptor> provideOkHttpNetworkInterceptors() {
    return emptyList();
  }
}
