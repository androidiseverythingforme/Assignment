package vikrant.wipro.com.assignment.data.contract;

import vikrant.wipro.com.assignment.data.listener.ICallbackListener;


/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

/**
 * This interface using as contract for feeds it will be implement by either Network/DB layer (facade pattern)
 *
 * @param <T>
 */
public interface IFeedRepository<T> {
    void getFeeds(ICallbackListener<T> callbackListener);
}
