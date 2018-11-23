package vikrant.wipro.com.assignment.presentation.splash;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class SplashPresenterImpl implements SplashContract.ISplashPresenter {
    private WeakReference<SplashContract.ISplashView> view;

    SplashPresenterImpl(SplashContract.ISplashView view) {
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


    @Override
    public void startSplashTimer(long splashTime) {
        if (view != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (view.get() != null) {
                        view.get().openDashboardActivity();
                    }
                }
            }, splashTime);
        }
    }
}
