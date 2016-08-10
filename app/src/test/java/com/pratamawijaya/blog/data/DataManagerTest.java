package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.model.pojo.Post;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.observers.TestSubscriber;

/**
 * Created by pratama on 7/18/16.
 */
public class DataManagerTest {

  @Mock PratamaService pratamaService;
  @Mock CacheProviders cacheProviders;
  @Mock DatabaseHelper databaseHelper;

  private DataManager dataManager;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    dataManager = new DataManager(cacheProviders, databaseHelper, pratamaService);
  }

  @Test public void get_post_should_return_value() throws Exception {
    TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
    dataManager.getPosts(1, true).subscribe(subscriber);
    subscriber.assertNoErrors();
  }
}