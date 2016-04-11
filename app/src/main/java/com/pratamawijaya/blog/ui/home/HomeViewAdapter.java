package com.pratamawijaya.blog.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.model.pojo.Post;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratama on 4/11/16.
 */
public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewAdapter.HomeHolder> {

  private Context context;
  private List<Post> listPost;

  public HomeViewAdapter(Context context) {
    this.context = context;
    listPost = new ArrayList<>();
  }

  public void clearPost() {
    listPost.clear();
  }

  public void addPost(List<Post> posts) {
    listPost.addAll(posts);
    notifyDataSetChanged();
  }

  @Override public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new HomeHolder(
        LayoutInflater.from(context).inflate(R.layout.view_item_post, parent, false));
  }

  @Override public void onBindViewHolder(HomeHolder holder, int position) {
    holder.postTitle.setText(listPost.get(position).title);
    holder.postExcrept.setText(listPost.get(position).excerpt);
  }

  @Override public int getItemCount() {
    return listPost.size();
  }

  public class HomeHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.post_title) TextView postTitle;
    @Bind(R.id.post_content_excrept) TextView postExcrept;

    public HomeHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
