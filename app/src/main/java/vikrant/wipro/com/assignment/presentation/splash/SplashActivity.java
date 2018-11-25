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
    private SplashContract.ISplashPresenter mPresenter;

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.startSplashTimer(AppConstant.SPLASH_TIME_OUT);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected BaseContract.IPresenter getPresenter() {
        return mPresenter == null ? mPresenter = new SplashPresenterImpl(this) : null;
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
    public void openNextActivity() {
        showContentView();
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

}

