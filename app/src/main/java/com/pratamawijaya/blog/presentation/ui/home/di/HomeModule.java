package com.pratamawijaya.blog.presentation.ui.home.di;

import android.app.Activity;
import com.pratamawijaya.blog.data.feature.post.PostRepositoryImpl;
import com.pratamawijaya.blog.domain.entity.Post;
import com.pratamawijaya.blog.domain.interactor.UseCase;
import com.pratamawijaya.blog.domain.interactor.post.GetBlogPosts;
import com.pratamawijaya.blog.domain.repository.PostRepository;
import com.pratamawijaya.blog.presentation.base.ActivityModule;
import com.pratamawijaya.blog.presentation.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

@Module public class HomeModule extends ActivityModule {

  public HomeModule(Activity activity) {
    super(activity);
  }

  @Provides @ActivityScope Activity activity() {
    return this.activity;
  }

  @Provides PostRepository providePostRepo(PostRepositoryImpl postRepository) {
    return postRepository;
  }

  @Provides UseCase<List<Post>> provideUseCase(GetBlogPosts getBlogPosts) {
    return getBlogPosts;
  }
}
