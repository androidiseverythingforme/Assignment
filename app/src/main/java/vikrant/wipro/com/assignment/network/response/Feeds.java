
package vikrant.wipro.com.assignment.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class Feeds extends BaseResponse {
    @SerializedName("title")
    private String headlineTitle;
    private ArrayList<Feed> feeds;

    public String getHeadlineTitle() {
        return headlineTitle;
    }

    public void setHeadlineTitle(String headlineTitle) {
        this.headlineTitle = headlineTitle;
    }

    public ArrayList<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<Feed> feeds) {
        this.feeds = feeds;
    }

    private class Feed {
        @SerializedName("title")
        private String title;

        @SerializedName("description")
        private String description;

        @SerializedName("imageHref")
        private String imageUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Feed{");
            sb.append("title='").append(title).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", imageUrl='").append(imageUrl).append('\'');
            sb.append('}');
            return sb.toString();
        }
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
