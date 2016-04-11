package com.pratamawijaya.blog.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.injection.component.ActivityComponent;
import com.pratamawijaya.blog.injection.component.DaggerActivityComponent;
import com.pratamawijaya.blog.injection.module.ActivityModule;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class BaseActivity extends AppCompatActivity {
  private ActivityComponent activityComponent;
  private Toolbar toolbar;

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    getToolbar();
  }

  public ActivityComponent getActivityComponent() {
    if (activityComponent == null) {
      activityComponent = DaggerActivityComponent.builder()
          .activityModule(new ActivityModule(this))
          .applicationComponent(BaseApplication.get(this).getApplicationComponent())
          .build();
    }
    return activityComponent;
  }

  /**
   * get toolbar
   *
   * @return Toolbar
   */
  protected Toolbar getToolbar() {
    if (toolbar == null) {
      toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
    }
    return toolbar;
  }
}
