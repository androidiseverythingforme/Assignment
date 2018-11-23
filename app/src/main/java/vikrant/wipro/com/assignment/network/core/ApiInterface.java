package vikrant.wipro.com.assignment.network.core;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vikrant.wipro.com.assignment.network.response.Feeds;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public interface ApiInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<Feeds> getFeeds();


}
