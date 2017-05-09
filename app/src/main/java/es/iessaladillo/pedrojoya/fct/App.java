package es.iessaladillo.pedrojoya.fct;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.amulyakhare.textdrawable.TextDrawable;

import es.iessaladillo.pedrojoya.fct.utils.AppUtils;
import es.iessaladillo.pedrojoya.fct.utils.TextDrawableUtils;

public class App extends Application {

    // VectorDrawable on old versions.
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static TextDrawable.IBuilder mTextDrawableBuilder;

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.initLeakCanary(this);
        AppUtils.initStetho(this);
        mTextDrawableBuilder = TextDrawableUtils.getRoundBuilder();
    }

    public static TextDrawable.IBuilder getTextDrawableBuilder() {
        return mTextDrawableBuilder;
    }

}
