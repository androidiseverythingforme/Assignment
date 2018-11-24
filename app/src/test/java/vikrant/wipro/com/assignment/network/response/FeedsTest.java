package vikrant.wipro.com.assignment.network.response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vikrant Alekar on 25-11-2018.
 */
public class FeedsTest {
    private Feeds mFeeds;
    private List<FeedInfo> feedData;

    @Before
    public void setUp() throws Exception {
        mFeeds = new Feeds();
        mFeeds.setHeadlineTitle("test_headline");
        mFeeds.setFeeds(getFeedData());
    }

    @After
    public void tearDown() throws Exception {
        mFeeds = null;
    }

    @Test
    public void getHeadlineTitle() {
        assertEquals(mFeeds.getHeadlineTitle(), "test_headline");
    }

    @Test
    public void getFeeds() {
        assertNotNull(mFeeds.getFeeds());
    }

    public List<FeedInfo> getFeedData() {
        List<FeedInfo> feeds = new ArrayList<>();
        FeedInfo feedInfo = new FeedInfo();
        feedInfo.setTitle("test_title");
        feedInfo.setDescription("test_description");
        feedInfo.setImageUrl("test_url");
        feeds.add(feedInfo);
        return feeds;
    }
}