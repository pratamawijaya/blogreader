package com.pratamawijaya.blog.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by pratama on 4/11/16.
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
  public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();

  private int previousTotal = 0; // The total number of items in the dataset after the last load
  private boolean loading = true; // True if we are still waiting for the last set of data to load.
  private int visibleThreshold = 5;
  // The minimum amount of items to have below your current scroll position before loading more.
  int firstVisibleItem, visibleItemCount, totalItemCount;

  private int current_page = 1;

  private LinearLayoutManager mLinearLayoutManager;

  public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
    this.mLinearLayoutManager = linearLayoutManager;
  }

  public void reset(int previousTotal, boolean loading) {
    this.previousTotal = previousTotal;
    this.loading = loading;
    this.current_page = 1;
  }

  @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);

    visibleItemCount = recyclerView.getChildCount();
    totalItemCount = mLinearLayoutManager.getItemCount();
    firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

    if (loading) {
      if (totalItemCount > previousTotal) {
        loading = false;
        previousTotal = totalItemCount;
      }
    }
    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
      // End has been reached

      // Do something
      current_page++;

      onLoadMore(current_page);

      loading = true;
    }
  }

  public abstract void onLoadMore(int current_page);
}