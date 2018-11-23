package vikrant.wipro.com.assignment.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * Created by Vikrant Alekar on 08-08-2018.
 */

/**
 * This class is using for network related util functions like to check internet is present or not?
 */
public class NetworkUtil {
    private NetworkUtil() {
    }

    public static boolean isNetworkConnectionAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
