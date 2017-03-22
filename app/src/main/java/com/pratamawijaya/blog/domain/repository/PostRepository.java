package com.pratamawijaya.blog.domain.repository;

import com.pratamawijaya.blog.domain.entity.Post;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public interface PostRepository {
  Observable<List<Post>> getPosts(final int page, final boolean isUpdate);

  Observable<Post> getPost(final int postID, final boolean isUpdate);
}
