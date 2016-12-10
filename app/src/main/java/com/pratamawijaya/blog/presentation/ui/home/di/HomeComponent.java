package com.pratamawijaya.blog.presentation.ui.home.di;

import com.pratamawijaya.blog.app.AppComponent;
import com.pratamawijaya.blog.presentation.di.scope.ActivityScope;
import com.pratamawijaya.blog.presentation.ui.home.HomeViewActivity;
import com.pratamawijaya.blog.presentation.ui.home.fragment.list.ListArticleFragment;
import dagger.Component;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

@Component(dependencies = AppComponent.class, modules = HomeModule.class) @ActivityScope
public interface HomeComponent {
  void inject(HomeViewActivity activity);

  void inject(ListArticleFragment fragment);
}
