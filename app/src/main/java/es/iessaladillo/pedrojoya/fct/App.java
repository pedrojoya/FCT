package es.iessaladillo.pedrojoya.fct;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import es.iessaladillo.pedrojoya.fct.utils.AppUtils;

public class App extends Application {

    // VectorDrawable on old versions.
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.initLeakCanary(this);
        AppUtils.initStetho(this);
    }

}
