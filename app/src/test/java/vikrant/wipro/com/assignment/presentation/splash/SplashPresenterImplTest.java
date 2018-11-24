package vikrant.wipro.com.assignment.presentation.splash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Vikrant Alekar on 25-11-2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterImplTest {
    private SplashPresenterImpl mSplashPresenter;
    @Mock
    private SplashContract.ISplashView mView;

    @Before
    public void setUp() throws Exception {
        mSplashPresenter = new SplashPresenterImpl(mView);
    }

    @After
    public void tearDown() throws Exception {
        mSplashPresenter = null;
    }

    @Test
    public void startSplashTimer() {
//        mSplashPresenter.startSplashTimer(100);
    }
}