package vikrant.wipro.com.assignment.presentation.splash;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class SplashPresenterImpl implements SplashContract.ISplashPresenter {
    private WeakReference<SplashContract.ISplashView> mView;

    SplashPresenterImpl(SplashContract.ISplashView view) {
        this.mView = new WeakReference<>(view);
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
        if (mView != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mView.get() != null) {
                        mView.get().openNextActivity();
                    }
                }
            }, splashTime);
        }
    }
}
