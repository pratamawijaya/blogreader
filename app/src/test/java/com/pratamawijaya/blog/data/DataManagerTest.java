package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by pratama on 7/18/16.
 */
@RunWith(MockitoJUnitRunner.class) public class DataManagerTest {

  @Mock PratamaService pratamaService;
  @Mock CacheProviders cacheProviders;
  @Mock DatabaseHelper databaseHelper;

  private DataManager dataManager;

  @Before public void setUp() throws Exception {
    dataManager = new DataManager(cacheProviders, databaseHelper, pratamaService);
  }

  @Test public void testData() throws Exception {
    //TestSubscriber<Reply<List<Post>>> replyTestSubscriber = new TestSubscriber<>();
    //dataManager.getPosts(1, true).subscribe(replyTestSubscriber);
    //replyTestSubscriber.assertNoErrors();
  }
}