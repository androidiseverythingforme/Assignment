package vikrant.wipro.com.assignment.presentation.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.base.BaseActivity;
import vikrant.wipro.com.assignment.base.BaseContract;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class DashboardActivity extends BaseActivity implements DashboardContract.IDashboardView {
    private DashboardContract.IDashboardPresenter presenter;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected BaseContract.IPresenter getPresenter() {
        if (presenter == null) {
            return presenter = new DashboardPresenterImpl(this);
        }
        return presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean isViewResumed() {
        return mIsResumed;
    }

    private void init() {
    }
}
