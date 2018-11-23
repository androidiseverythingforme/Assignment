package vikrant.wipro.com.assignment.presentation.dashboard;

import java.lang.ref.WeakReference;

import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.network.ICallbackListener;
import vikrant.wipro.com.assignment.network.repository.FeedRepository;
import vikrant.wipro.com.assignment.network.response.Feeds;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class DashboardPresenterImpl implements DashboardContract.IDashboardPresenter {
    private WeakReference<DashboardContract.IDashboardView> view;

    DashboardPresenterImpl(DashboardContract.IDashboardView view) {
        this.view = new WeakReference<DashboardContract.IDashboardView>(view);
    }

    /**
     * Overrides
     */

    @Override
    public void onViewAttached() {
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void getFeeds() {
        new FeedRepository().getFeeds(new ICallbackListener<Feeds>() {
            @Override
            public void onSuccess(Feeds response) {
                if (view.get() != null) {
                    view.get().successInFeedRetrieval(response);
                }
            }

            @Override
            public void onError(AppException exception) {
                if (view.get() != null) {
                    view.get().errorInFeedsRetrieval(exception);
                }
            }
        });
    }
}
