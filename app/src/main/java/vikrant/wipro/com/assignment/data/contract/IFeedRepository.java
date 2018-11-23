package vikrant.wipro.com.assignment.data.contract;

import vikrant.wipro.com.assignment.network.ICallbackListener;


/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

/**
 * This interface using as contract for feeds it will be implement by either network/DB layer
 *
 * @param <T>
 */
public interface IFeedRepository<T> {
    void getFeeds(ICallbackListener<T> callbackListener);
}
