package com.pratamawijaya.blog.app;

import com.pratamawijaya.blog.app.config.MainInitializer;
import com.pratamawijaya.blog.app.config.SupportModule;
import com.pratamawijaya.blog.data.network.ApiModule;
import com.pratamawijaya.blog.data.network.NetworkModule;
import com.pratamawijaya.blog.presentation.di.UIModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by pratama on 10/3/16.
 */

@Singleton @Component(modules = {
    AppModule.class, SupportModule.class, NetworkModule.class, ApiModule.class, UIModule.class
}) public interface AppComponent extends AppDependencies {
  void inject(PratamaBlogApplication app);

  void inject(MainInitializer initializer);
}
