package com.pratamawijaya.blog.data.network;

import android.app.Application;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.List;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by pratama on 9/30/16.
 */
@Module public class NetworkModule {
  private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB
  private static final String DISK_CACHE_FOLDER = "pratama_blog";

  @Provides @Singleton OkHttpClient provideOkHttpClient(Application app,
      final @OkHttpInterceptors @NonNull List<Interceptor> interceptors,
      final @OkHttpNetworkInterceptors @NonNull List<Interceptor> networkInterceptors) {
    return createOkHttpClient(createOkHttpClientBuilder(app), interceptors, networkInterceptors);
  }

  private static OkHttpClient createOkHttpClient(final OkHttpClient.Builder builder,
      final List<Interceptor> interceptors, final List<Interceptor> networkInterceptors) {
    for (Interceptor interceptor : interceptors) {
      builder.addInterceptor(interceptor);
    }

    for (Interceptor networkInterceptor : networkInterceptors) {
      builder.addNetworkInterceptor(networkInterceptor);
    }
    return builder.build();
  }

  private static OkHttpClient.Builder createOkHttpClientBuilder(final Application app) {
    return new OkHttpClient.Builder().cache(createHttpCache(app));
  }

  private static Cache createHttpCache(Application application) {
    File cacheDir = new File(application.getCacheDir(), DISK_CACHE_FOLDER);
    return new Cache(cacheDir, DISK_CACHE_SIZE);
  }
}
