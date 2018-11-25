package vikrant.wipro.com.assignment.presentation.splash;

import vikrant.wipro.com.assignment.base.BaseContract;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
class SplashContract {

    public interface ISplashPresenter extends BaseContract.IPresenter {
        void startSplashTimer(long splashTime);
    }

    public interface ISplashView extends BaseContract.IView {
        void openNextActivity();
    }
}
