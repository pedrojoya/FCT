package es.iessaladillo.pedrojoya.fct.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class AppUtils {

    private AppUtils() {
    }

    public static void initLeakCanary(Application application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            return;
        }
        LeakCanary.install(application);
    }

    public static void initStetho(Context context) {
        Stetho.initializeWithDefaults(context.getApplicationContext());
    }

}
