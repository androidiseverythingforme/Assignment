package vikrant.wipro.com.assignment.network.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.network.ICallbackListener;
import vikrant.wipro.com.assignment.network.core.ApiClient;
import vikrant.wipro.com.assignment.network.core.ApiInterface;
import vikrant.wipro.com.assignment.data.contract.IFeedRepository;
import vikrant.wipro.com.assignment.network.response.Feeds;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

/**
 * This class is using for getting feeds from network
 */
public class FeedRepository implements IFeedRepository<Feeds> {
    private static ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getFeeds(final ICallbackListener<Feeds> callbackListener) {
        if (callbackListener != null) {
            apiService.getFeeds().enqueue(new Callback<Feeds>() {
                @Override
                public void onResponse(Call<Feeds> call, Response<Feeds> response) {
                    if (response != null && response.body() != null) {
                        callbackListener.onSuccess(response.body());
                    } else {
                        callbackListener.onError(new AppException(AppException.AppExceptionType.GENERAL, "No feeds found."));
                    }
                }

                @Override
                public void onFailure(Call<Feeds> call, Throwable t) {
                    callbackListener.onError(new AppException(AppException.AppExceptionType.SERVER_EXCEPTION, t.getMessage()));
                }
            });
        }
    }
}
