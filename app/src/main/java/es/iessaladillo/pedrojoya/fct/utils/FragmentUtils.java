package es.iessaladillo.pedrojoya.fct.utils;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentUtils {

    private FragmentUtils() {
    }

    public static void replaceFragment(FragmentManager fragmentManager, @IdRes int resId,
            Fragment fragment) {
        fragmentManager.beginTransaction().replace(resId, fragment).commitNow();
    }
}
