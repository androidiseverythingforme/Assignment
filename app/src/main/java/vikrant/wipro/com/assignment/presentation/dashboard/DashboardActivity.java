package vikrant.wipro.com.assignment.presentation.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import vikrant.wipro.com.assignment.network.response.Feeds;
import vikrant.wipro.com.assignment.presentation.details.FeedDetailActivity;
import vikrant.wipro.com.assignment.presentation.details.ItemClickListener;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class DashboardActivity extends BaseActivity implements DashboardContract.IDashboardView {
    private DashboardContract.IDashboardPresenter mPresenter;
    private List<FeedInfo> mFeeds = new ArrayList<>();
    private int mLoadedItems = 0;
    private int mTotalItems = 14; //Currently given server API doesnt giving total items count so here am assuming total items will be 14
    private FeedAdapter mFeedAdapter;
    private RecyclerView mRecyclerView;
    private ItemClickListener<FeedInfo> mItemClickListener;

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
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                //Call API related code here to get data from network / DB layer
                if (mLoadedItems <= mTotalItems) {
                    getFeeds();
                }
            }
        });

        mItemClickListener = new ItemClickListener<FeedInfo>() {
            @Override
            public void onItemClick(FeedInfo feedInfo) {
                startActivity(new Intent(DashboardActivity.this, FeedDetailActivity.class).putExtra(FeedDetailActivity.FEED_DETAIL, feedInfo));
            }
        };
    }

    @Override
    public void successInFeedRetrieval(Feeds data) {
        showContentView();
        mFeeds.clear();
        mFeeds = data.getFeeds();
        getSupportActionBar().setTitle(data.getHeadlineTitle());
        mLoadedItems = mFeeds.size();
        mFeedAdapter = new FeedAdapter(mFeeds, mItemClickListener);
        mRecyclerView.setAdapter(mFeedAdapter);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mItemClickListener = null;
    }

    private void getFeeds() {
        if (mPresenter != null) {
            showLoadingView();
            mPresenter.getFeeds();
        }
    }
}
