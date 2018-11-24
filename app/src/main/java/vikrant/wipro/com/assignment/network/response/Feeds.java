
package vikrant.wipro.com.assignment.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 * <p>
 * This class is POJO class to hold feeds information
 * <p>
 * This class is POJO class to hold feeds information
 */

/**
 * This class is POJO class to hold feeds information
 */

/**
 * This class holds list of feeds info with its header
 */
public class Feeds {
    @SerializedName("title")
    @Expose
    private String headlineTitle;
    @SerializedName("rows")
    @Expose
    private List<FeedInfo> feed = null;

    public String getHeadlineTitle() {
        return headlineTitle;
    }

    public void setHeadlineTitle(String headlineTitle) {
        this.headlineTitle = headlineTitle;
    }

    public List<FeedInfo> getFeeds() {
        return feed;
    }

    public void setFeeds(List<FeedInfo> feeds) {
        this.feed = feeds;
    }

}
