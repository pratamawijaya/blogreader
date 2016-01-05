package com.pratamawijaya.blog.data;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.pratamawijaya.blog.App;
import com.pratamawijaya.blog.utils.AndroidComponentUtil;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Subscription;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Singleton public class SyncService extends Service {
  @Inject DataManager dataManager;
  private Subscription subscription;

  public static Intent getStartIntent(Context context) {
    return new Intent(context, SyncService.class);
  }

  @Nullable @Override public IBinder onBind(Intent intent) {
    return null;
  }

  public static boolean isRunning(Context context) {
    return AndroidComponentUtil.isServiceRunning(context, SyncService.class);
  }

  @Override public void onCreate() {
    super.onCreate();
    App.get(this).getApplicationComponent().inject(this);
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);
  }
}
