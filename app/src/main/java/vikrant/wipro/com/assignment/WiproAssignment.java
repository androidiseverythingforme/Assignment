package vikrant.wipro.com.assignment;

import android.app.Application;
import android.content.Context;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */
public class WiproAssignment extends Application {
    public static WiproAssignment sInstance = null;

    public static WiproAssignment getInstance() {
        if (sInstance == null) {
            sInstance = new WiproAssignment();
        }
        return sInstance;
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        init();
    }

    private void init() {
        //initialise your stuff here
    }
}