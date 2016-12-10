package com.pratamawijaya.blog.presentation.utils;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class PicassoImageLoader implements PratamaImageLoader {

  @NonNull private final Picasso picasso;

  public PicassoImageLoader(@NonNull Picasso picasso) {
    this.picasso = picasso;
  }

  @Override public void downloadImageInto(@NonNull String url, @NonNull ImageView imageView) {
    picasso.load(url).into(imageView);
  }
}
