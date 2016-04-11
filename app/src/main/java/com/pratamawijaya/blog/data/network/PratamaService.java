package com.pratamawijaya.blog.data.network;

import com.google.gson.Gson;
import com.pratamawijaya.blog.BuildConfig;
import com.pratamawijaya.blog.model.response.PostResponse;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public interface PratamaService {
  @GET("get_recent_posts/") Observable<PostResponse> getRecentPost(@Query("page") int page);

  class Creator {
    @Inject public static PratamaService newPratamaService(OkHttpClient okHttpClient, Gson gson) {
      Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .build();
      return retrofit.create(PratamaService.class);
    }
  }
}
