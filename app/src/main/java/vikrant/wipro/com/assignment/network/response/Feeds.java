
package vikrant.wipro.com.assignment.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

/**
 * This class is POJO class to hold feeds information
 */

public class Feeds {
    @SerializedName("title")
    @Expose
    private String headlineTitle;
    @SerializedName("rows")
    @Expose
    private List<FeedInfo> feeds = null;

    public String getHeadlineTitle() {
        return headlineTitle;
    }

    public void setHeadlineTitle(String headlineTitle) {
        this.headlineTitle = headlineTitle;
    }

    public List<FeedInfo> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedInfo> feeds) {
        this.feeds = feeds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feeds{");
        sb.append("headlineTitle='").append(headlineTitle).append('\'');
        sb.append(", feeds=").append(feeds);
        sb.append('}');
        return sb.toString();
    }
}
