package com.pratamawijaya.blog.presentation.di;

import android.app.Application;
import android.support.annotation.NonNull;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.pratamawijaya.blog.presentation.utils.PicassoImageLoader;
import com.pratamawijaya.blog.presentation.utils.PratamaImageLoader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

@Module public class UIModule {

  @Provides @NonNull @Singleton public Picasso providePicasso(@NonNull Application application,
      @NonNull OkHttpClient okHttpClient) {
    return new Picasso.Builder(application).downloader(new OkHttp3Downloader(okHttpClient)).build();
  }

  @Provides @NonNull @Singleton
  public PratamaImageLoader provideImageDownload(@NonNull Picasso picasso) {
    return new PicassoImageLoader(picasso);
  }
}
