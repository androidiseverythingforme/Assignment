package vikrant.wipro.com.assignment.presentation.dashboard;


import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.base.BaseContract;
import vikrant.wipro.com.assignment.network.response.Feeds;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
class DashboardContract {

    public interface IDashboardPresenter extends BaseContract.IPresenter {
        void getFeeds();
    }

    public interface IDashboardView extends BaseContract.IView {
        void successInFeedRetrieval(Feeds feeds);

        void errorInFeedsRetrieval(AppException exception);

    }
}
