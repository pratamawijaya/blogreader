package com.pratamawijaya.blog.data.local;

import io.realm.Realm;
import javax.inject.Inject;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class DatabaseHelper {

  private Realm realm;

  @Inject public DatabaseHelper(Realm realm) {
    this.realm = realm;
  }
}
