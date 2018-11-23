package vikrant.wipro.com.assignment.presentation.dashboard;


import java.util.List;

import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.base.BaseContract;
import vikrant.wipro.com.assignment.network.response.FeedInfo;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
class DashboardContract {

    public interface IDashboardPresenter extends BaseContract.IPresenter {
        void getFeeds();
    }

    public interface IDashboardView extends BaseContract.IView {
        void successInFeedRetrieval(List<FeedInfo> feeds);

        void errorInFeedsRetrieval(AppException exception);

    }
}
