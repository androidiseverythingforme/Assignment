package vikrant.wipro.com.assignment.presentation.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.base.AppException;
import vikrant.wipro.com.assignment.base.BaseActivity;
import vikrant.wipro.com.assignment.base.BaseContract;
import vikrant.wipro.com.assignment.network.response.FeedInfo;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class DashboardActivity extends BaseActivity implements DashboardContract.IDashboardView {
    private DashboardContract.IDashboardPresenter mPresenter;
    private List<FeedInfo> mFeeds;
    private int mLoadedItems = 0;
    private FeedAdapter mFeedAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getFeeds();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected BaseContract.IPresenter getPresenter() {
        if (mPresenter == null) {
            return mPresenter = new DashboardPresenterImpl(this);
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
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DashboardActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(DashboardActivity.this, DividerItemDecoration.VERTICAL));
        mFeeds = new ArrayList<>();
        mFeedAdapter = new FeedAdapter(mFeeds);
        mRecyclerView.setAdapter(mFeedAdapter);
        addDataToList();

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                //Call API related code here to get data
                if (mLoadedItems <= 30) {
                    addDataToList();
                }
            }
        });

    }

    private void addDataToList() {
//        showLoadingView();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 20; i++) {
//                    FeedInfo feedInfo = new FeedInfo();
//                    feedInfo.setTitle("Title " + i);
//                    feedInfo.setDescription("Description " + i);
//                    feedInfo.setImageUrl("Url " + i);
//                    mFeeds.add(feedInfo);
//                    mLoadedItems++;
//                }
//                mFeedAdapter.notifyDataSetChanged();
//                showContentView();
//            }
//        }, 1500);
    }

    @Override
    public void successInFeedRetrieval(List<FeedInfo> feeds) {
        mFeeds = feeds;
        mFeedAdapter.notifyDataSetChanged();
        showContentView();
    }

    @Override
    public void errorInFeedsRetrieval(AppException exception) {
        mFeeds = null;
        mFeedAdapter.notifyDataSetChanged();
        showErrorView(exception, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFeeds();
            }
        });
    }

    private void getFeeds() {
        if (mPresenter != null) {
            showToast(R.string.toast_msg_getfeeds);
            mPresenter.getFeeds();
        }
    }
}
