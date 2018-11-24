package vikrant.wipro.com.assignment.presentation.dashboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;

/**
 * Created by Vikrant Alekar on 25-11-2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class DashboardPresenterImplTest {
    private DashboardPresenterImpl mDashboardPresenter;
    private DashboardContract.IDashboardView mView;


    @Before
    public void setUp() throws Exception {
        mDashboardPresenter = new DashboardPresenterImpl(mView);
    }

    @After
    public void tearDown() throws Exception {
        mDashboardPresenter = null;
    }

    @Test
    public void getFeeds() {
//        mDashboardPresenter.getFeeds();
    }
}