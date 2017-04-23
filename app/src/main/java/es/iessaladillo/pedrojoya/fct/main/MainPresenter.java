package es.iessaladillo.pedrojoya.fct.main;

import android.os.Bundle;
import android.support.annotation.IdRes;

import es.iessaladillo.pedrojoya.fct.R;

class MainPresenter implements MainContract.Presenter {

    MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void onViewAttach(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onViewDetach() {
    }

    @Override
    public void onDestroy() {
        mView = new MainContract.View() {
            @Override
            public void navigateToStudentsFragment() {

            }

            @Override
            public void navigateToCompaniesFragment() {

            }

            @Override
            public void navigateToPreferencesActivity() {

            }

            @Override
            public void performFabClickOnCurrentFragment() {

            }

            @Override
            public void navigateToNextVisitsFragment() {

            }

            @Override
            public void navigateToVisitActivity() {

            }
        };
    }

    @Override
    public MainContract.View getView() {
        return mView;
    }

    @Override
    public boolean doOnNavigationItemSelected(@IdRes int itemId) {
        if (itemId == R.id.mnuNewVisit) {
            mView.navigateToVisitActivity();
            return true;
        } else if (itemId == R.id.mnuNextVisits) {
            mView.navigateToNextVisitsFragment();
            return true;
        } else if (itemId == R.id.mnuStudents) {
            mView.navigateToStudentsFragment();
            return true;
        } else if (itemId == R.id.mnuCompanies) {
            mView.navigateToCompaniesFragment();
            return true;
        } else if (itemId == R.id.mnuPreferences) {
            mView.navigateToPreferencesActivity();
            return true;
        }
        return false;
    }

    @Override
    public void doOnFabClicked() {
        mView.performFabClickOnCurrentFragment();
    }

    @Override
    public void loadMainFragment(Bundle savedInstanceState) {
        // TODO Select MainFragment according to Preferences.
        if (savedInstanceState == null) {
            mView.navigateToStudentsFragment();
        }
    }

}
