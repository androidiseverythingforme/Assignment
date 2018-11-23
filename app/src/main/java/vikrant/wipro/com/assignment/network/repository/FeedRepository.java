package vikrant.wipro.com.assignment.network.repository;

import vikrant.wipro.com.assignment.network.core.ApiClient;
import vikrant.wipro.com.assignment.network.core.ApiInterface;
import vikrant.wipro.com.assignment.data.contract.IFeedRepository;
import vikrant.wipro.com.assignment.network.response.Feeds;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */


public class FeedRepository implements IFeedRepository {
    private static ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);


    @Override
    public Feeds getFeedList() {
        Feeds feeds = new Feeds();
        return feeds;
    }
}
