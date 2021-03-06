package vikrant.wipro.com.assignment.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.progress_view.ProgressLayout;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.WiproAssignment;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.IView {
    private ProgressLayout mProgressLayout;
    protected boolean mIsResumed;
    private Drawable mEmptyDrawable;
    private Drawable mErrorDrawable;

    /**
     * Lifecycle methods
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initView();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mIsResumed = true;
    }

    @Override
    protected void onPause() {
        mIsResumed = false;
        super.onPause();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        BaseContract.IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onViewAttached();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseContract.IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onViewDetached();
        }
    }

    public boolean isActivityResumed() {
        return mIsResumed;
    }

    @Override
    public void showLoadingView() {
        mProgressLayout.showLoading();
        hideKeyboard();
    }

    @Override
    public void showEmptyView() {
        mProgressLayout.showEmpty(mEmptyDrawable, getResources().getString(R.string.no_data_found_title), getResources().getString(R.string.no_data_found_msg));
        hideKeyboard();
    }

    @Override
    public void showErrorView(AppException e, View.OnClickListener clickListener) {
        if (e.getExceptionType() == AppException.AppExceptionType.VALIDATION_EXCEPTION) {
            showToast(e.getErrorMessage());
            showContentView();
        } else {
            mProgressLayout.showError(mErrorDrawable,
                    e.getExceptionType().toString(),
                    e.getErrorMessage(),
                    getResources().getString(R.string.try_again), clickListener);
        }
        hideKeyboard();
    }

    @Override
    public void showContentView() {
        mProgressLayout.showContent();
    }

    /**
     * Public methods
     * This is capturing method for IView's showToast method and hence access specifier scope can't be reduced.
     */
    public void showToast(String toastMsg) {
        Toast.makeText(WiproAssignment.getContext(), toastMsg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int stingResourceID) {
        Toast.makeText(WiproAssignment.getContext(), getResources().getString(stingResourceID), Toast.LENGTH_SHORT).show();
    }

    /**
     * Abstract/Protected methods
     */
    protected abstract int getLayoutResource();

    protected abstract BaseContract.IPresenter getPresenter();

    private void initView() {
        mProgressLayout = (ProgressLayout) findViewById(R.id.progress);
        mEmptyDrawable = getResources().getDrawable(R.drawable.ic_empty);
        mErrorDrawable = getResources().getDrawable(R.drawable.ic_error);
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
