package vikrant.wipro.com.assignment.presentation.details;

import vikrant.wipro.com.assignment.base.AppException;

/**
 * This interface is using for callback for item click
 */
public interface ItemClickListener<T> {
    void onItemClick(T t);
}
