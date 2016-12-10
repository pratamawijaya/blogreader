package com.pratamawijaya.blog.data.model.mapper;

import com.pratamawijaya.blog.data.model.PostModel;
import com.pratamawijaya.blog.domain.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class PostModelMapper {

  @Inject public PostModelMapper() {
  }

  public Post transform(PostModel postModel) {
    Post post = null;
    if (postModel != null) {
      post = new Post(postModel.id);
      post.type = postModel.type;
      post.title = postModel.title;
      post.content = postModel.content;
      post.excerpt = postModel.excerpt;
      post.date = postModel.date;
    }
    return post;
  }

  public List<Post> transform(List<PostModel> postModels) {
    List<Post> posts = new ArrayList<>();
    Post post;
    for (PostModel data : postModels) {
      post = transform(data);
      if (post != null) {
        posts.add(post);
      }
    }
    return posts;
  }
}
