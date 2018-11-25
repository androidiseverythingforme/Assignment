package vikrant.wipro.com.assignment.network.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vikrant.wipro.com.assignment.WiproAssignment;
import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.data.listener.ICallbackListener;
import vikrant.wipro.com.assignment.network.core.ApiClient;
import vikrant.wipro.com.assignment.network.core.ApiInterface;
import vikrant.wipro.com.assignment.data.contract.IFeedRepository;
import vikrant.wipro.com.assignment.network.response.Feeds;
import vikrant.wipro.com.assignment.util.NetworkUtil;

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
            if (NetworkUtil.isNetworkConnectionAvailable(WiproAssignment.getContext())) {
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
            } else {
                callbackListener.onError(new AppException(AppException.AppExceptionType.NETWORK_NOT_AVAILABLE_ERROR, "Network unavailable."));
            }
        }
    }
}
