package vikrant.wipro.com.assignment.presentation.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.base.AppConstant;
import vikrant.wipro.com.assignment.base.BaseActivity;
import vikrant.wipro.com.assignment.base.BaseContract;
import vikrant.wipro.com.assignment.presentation.dashboard.DashboardActivity;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class SplashActivity extends BaseActivity implements SplashContract.ISplashView {
    private SplashContract.ISplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (presenter != null) {
            presenter.startSplashTimer(AppConstant.SPLASH_TIME_OUT);
            showLoadingView();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected BaseContract.IPresenter getPresenter() {
        if (presenter == null) {
            return presenter = new SplashPresenterImpl(this);
        }
        return presenter;
    }

    @Override
    public Context getContext() {
        return SplashActivity.this;
    }

    @Override
    public boolean isViewResumed() {
        return mIsResumed;
    }


    @Override
    public void openDashboardActivity() {
        showContentView();
        showToast("Redirecting to dashboard");
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

}

