package vikrant.wipro.com.assignment.presentation.details;

import java.lang.ref.WeakReference;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class FeedDetailPresenterImpl implements FeedDetailContract.IDashboardPresenter {
    private WeakReference<FeedDetailContract.IDashboardView> view;

    FeedDetailPresenterImpl(FeedDetailContract.IDashboardView view) {
        this.view = new WeakReference<>(view);
    }

    /**
     * Overrides
     */

    @Override
    public void onViewAttached() {
        //empty
    }

    @Override
    public void onViewDetached() {
        //empty
    }
}
