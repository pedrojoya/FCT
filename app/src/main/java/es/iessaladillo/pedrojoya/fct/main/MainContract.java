package es.iessaladillo.pedrojoya.fct.main;

import android.os.Bundle;
import android.support.annotation.IdRes;

import es.iessaladillo.pedrojoya.fct.base.BasePresenter;

public interface MainContract {

    interface Presenter extends BasePresenter<View> {
        boolean doOnNavigationItemSelected(@IdRes int itemId);

        void doOnFabClicked();

        void loadMainFragment(Bundle savedInstanceState);
    }

    interface View {
        void navigateToStudentsFragment();

        void navigateToCompaniesFragment();

        void navigateToPreferencesActivity();

        void performFabClickOnCurrentFragment();

        void navigateToNextVisitsFragment();

        void navigateToVisitActivity();
    }

}
