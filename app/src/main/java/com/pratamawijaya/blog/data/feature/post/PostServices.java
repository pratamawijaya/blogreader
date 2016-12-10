package com.pratamawijaya.blog.data.feature.post;

import com.pratamawijaya.blog.data.model.response.PostResponse;
import com.pratamawijaya.blog.data.model.response.PostsResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public interface PostServices {
  @GET("get_recent_posts/") Observable<PostsResponse> getRecentPosts(@Query("page") int page);

  @GET("get_post/") Observable<PostResponse> getPost(@Query("post_id") int postId);
}
