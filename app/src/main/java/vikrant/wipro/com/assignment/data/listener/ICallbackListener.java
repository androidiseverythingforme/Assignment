package vikrant.wipro.com.assignment.data.listener;

import vikrant.wipro.com.assignment.base.AppException;

/**
 * This interface is using for callback from network/db layer to presenter
 *
 * @param <T>
 */
public interface ICallbackListener<T> {
    void onSuccess(T response);

    void onError(AppException exception);
}
