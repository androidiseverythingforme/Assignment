package vikrant.wipro.com.assignment.presentation.details;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.base.BaseActivity;
import vikrant.wipro.com.assignment.base.BaseContract;
import vikrant.wipro.com.assignment.network.response.FeedInfo;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class FeedDetailActivity extends BaseActivity implements FeedDetailContract.IDashboardView {
    private FeedDetailContract.IDashboardPresenter mPresenter;
    public static final String FEED_DETAIL = "feed_detail";
    private FeedInfo mFeedDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_feed_detail;
    }

    @Override
    protected BaseContract.IPresenter getPresenter() {
        if (mPresenter == null) {
            return mPresenter = new FeedDetailPresenterImpl(this);
        }
        return mPresenter;
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
        getDataFromPreviousActivity();
        if (mFeedDetails != null) {
            getSupportActionBar().setTitle(mFeedDetails != null ? mFeedDetails.getTitle() : "");
            ((TextView) findViewById(R.id.text_view_description)).setText(mFeedDetails.getDescription());
            Picasso.with(this).load(mFeedDetails.getImageUrl()).into((ImageView) findViewById(R.id.image_view_feed_image));
        }

    }

    private void getDataFromPreviousActivity() {
        mFeedDetails = (FeedInfo) getIntent().getExtras().get(FEED_DETAIL);
    }
}
