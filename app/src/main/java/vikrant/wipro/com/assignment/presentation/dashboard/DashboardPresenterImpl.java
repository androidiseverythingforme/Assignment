package vikrant.wipro.com.assignment.presentation.dashboard;
import java.lang.ref.WeakReference;
/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class DashboardPresenterImpl implements DashboardContract.IDashboardPresenter {
    private WeakReference<DashboardContract.IDashboardView> view;

    DashboardPresenterImpl(DashboardContract.IDashboardView view) {
        this.view = new WeakReference<DashboardContract.IDashboardView>(view);
    }

    /**
     * Overrides
     */

    @Override
    public void onViewAttached() {
    }

    @Override
    public void onViewDetached() {

    }

}
