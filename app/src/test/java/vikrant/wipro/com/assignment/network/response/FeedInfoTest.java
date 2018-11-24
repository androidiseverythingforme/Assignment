package vikrant.wipro.com.assignment.network.response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vikrant Alekar on 25-11-2018.
 */
public class FeedInfoTest {
    private FeedInfo feedInfo;

    @Before
    public void setUp() throws Exception {
        feedInfo = new FeedInfo();
        feedInfo.setTitle("test_title");
        feedInfo.setDescription("test_description");
        feedInfo.setImageUrl("test_url");
    }

    @After
    public void tearDown() throws Exception {
        feedInfo = null;
    }

    @Test
    public void getTitle() {
        assertEquals(feedInfo.getTitle(), "test_title");

    }

    @Test
    public void getDescription() {
        assertEquals(feedInfo.getDescription(), "test_description");

    }

    @Test
    public void getImageUrl() {
        assertEquals(feedInfo.getImageUrl(), "test_url");
    }


}