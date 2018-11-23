package vikrant.wipro.com.assignment.presentation.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.network.response.FeedInfo;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<FeedInfo> mFeedList;

    public FeedAdapter(List<FeedInfo> feeds) {
        this.mFeedList = feeds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mFeedList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_name);
        }
    }
}