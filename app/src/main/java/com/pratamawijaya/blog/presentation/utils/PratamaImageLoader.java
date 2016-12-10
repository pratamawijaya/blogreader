package com.pratamawijaya.blog.presentation.utils;

import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface PratamaImageLoader {
  void downloadImageInto(@NonNull String url, @NonNull ImageView imageView);
}
