package vikrant.wipro.com.assignment.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */


public class BaseContract {

    public interface IPresenter {

        void onViewAttached();

        void onViewDetached();

    }


    public interface IView {
        void showLoadingView();

        void showEmptyView();

        void showErrorView(AppException e, View.OnClickListener clickListener);

        void showContentView();

        Context getContext();

        void showToast(String toastMsg);

        boolean isViewResumed();
    }

}
