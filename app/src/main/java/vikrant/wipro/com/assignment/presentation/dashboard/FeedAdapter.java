package vikrant.wipro.com.assignment.presentation.dashboard;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.WiproAssignment;
import vikrant.wipro.com.assignment.network.response.FeedInfo;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    private List<FeedInfo> mFeedList;

    public FeedAdapter(List<FeedInfo> feeds) {
        this.mFeedList = feeds;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_feed, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.tvFeedTitle.setText(mFeedList.get(position).getTitle());
        holder.tvFeedDescription.setText(mFeedList.get(position).getDescription());
        if (!TextUtils.isEmpty(mFeedList.get(position).getImageUrl())) {
            Picasso.with(WiproAssignment.getContext()).load(mFeedList.get(position).getImageUrl()).into(holder.ivFeedImage);
        } else {
            holder.ivFeedImage.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }

    static class FeedViewHolder extends RecyclerView.ViewHolder {
        TextView tvFeedTitle;
        TextView tvFeedDescription;
        ImageView ivFeedImage;

        FeedViewHolder(View itemView) {
            super(itemView);
            tvFeedTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            tvFeedDescription = (TextView) itemView.findViewById(R.id.text_view_description);
            ivFeedImage = (ImageView) itemView.findViewById(R.id.image_view_image);
        }
    }
}