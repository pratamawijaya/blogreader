package com.pratamawijaya.blog.injection.module;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pratamawijaya.blog.data.Migration;
import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.injection.ApplicationContext;
import com.pratamawijaya.blog.utils.GsonDateDeSerializer;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.lang.reflect.Modifier;
import javax.inject.Singleton;
import org.joda.time.DateTime;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Module public class ApplicationModule {
  private static final long DATABASE_VERSION = 1;
  protected final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides Application provideApplication() {
    return application;
  }

  @Provides @ApplicationContext Context provideContext() {
    return application;
  }

  @Provides @Singleton static OkHttpClient providesOkHttpClient() {
    OkHttpClient okHttpClient = new OkHttpClient();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    okHttpClient.interceptors().add(interceptor);
    return okHttpClient;
  }

  @Provides @Singleton static Gson providesGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
    gsonBuilder.registerTypeAdapter(DateTime.class, new GsonDateDeSerializer());
    return gsonBuilder.create();
  }

  @Provides @Singleton static PratamaService provideService(OkHttpClient okHttpClient, Gson gson) {
    return PratamaService.Creator.newPratamaService(okHttpClient, gson);
  }

  @Provides @Singleton static DatabaseHelper provideDatabaseHelper(Realm realm) {
    return new DatabaseHelper(realm);
  }

  @Provides static Realm provideRealm(@ApplicationContext Context context) {
    RealmConfiguration configuration =
        new RealmConfiguration.Builder(context).name("pratamablog.realm")
            .schemaVersion(DATABASE_VERSION)
            .migration(new Migration())
            .build();

    return Realm.getInstance(configuration);
  }
}
