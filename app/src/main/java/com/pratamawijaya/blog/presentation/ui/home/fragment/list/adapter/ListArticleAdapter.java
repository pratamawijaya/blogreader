package com.pratamawijaya.blog.presentation.ui.home.fragment.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.domain.entity.Post;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class ListArticleAdapter extends RecyclerView.Adapter<ListArticleAdapter.ListArticleHolder> {
  private Context context;
  public List<Post> posts;

  public ListArticleAdapter(List<Post> posts, Context context) {
    this.posts = posts;
    this.context = context;
  }

  @Override public ListArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ListArticleHolder(
        LayoutInflater.from(context).inflate(R.layout.view_item_post, parent, false));
  }

  @Override public void onBindViewHolder(ListArticleHolder holder, int position) {
    holder.bindItem(posts.get(position));
  }

  @Override public int getItemCount() {
    return posts.size();
  }

  public class ListArticleHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.post_title) TextView tvTitle;

    public ListArticleHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void bindItem(Post post) {
      tvTitle.setText(post.title);
    }
  }
}
