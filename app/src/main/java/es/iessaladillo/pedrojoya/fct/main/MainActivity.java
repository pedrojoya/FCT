package es.iessaladillo.pedrojoya.fct.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.iessaladillo.pedrojoya.fct.R;
import es.iessaladillo.pedrojoya.fct.students.StudentsFragmentStarter;
import es.iessaladillo.pedrojoya.fct.utils.FabUtils;
import es.iessaladillo.pedrojoya.fct.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener, MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private MainPresenter mPresenter;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenter(this);
        mFragmentManager = getSupportFragmentManager();
        initViews();
        mPresenter.loadMainFragment(savedInstanceState);
    }

    private void initViews() {
        setupToolbar();
        setupDrawer();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.main_activity_navigation_drawer_open, R.string.main_activity_navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return mPresenter.doOnNavigationItemSelected(item.getItemId());
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        mPresenter.doOnFabClicked();
    }

    @Override
    public void navigateToStudentsFragment() {
        navView.getMenu().findItem(R.id.mnuStudents).setChecked(true);
        FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.content_main,
                StudentsFragmentStarter.newInstance(
                        getString(R.string.activity_main_menu_students)));
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void navigateToCompaniesFragment() {
        navView.getMenu().findItem(R.id.mnuStudents).setChecked(true);
        // TODO
        Toast.makeText(this, "Fragmento de empresas", Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void navigateToPreferencesActivity() {
        // TODO
        Toast.makeText(this, "Actividad de preferencias", Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void performFabClickOnCurrentFragment() {
        Fragment frg = mFragmentManager.findFragmentById(R.id.content_main);
        if (frg != null) {
            try {
                ((FabUtils.OnFabClickListener) frg).onFabClick();
            } catch (Exception e) {
                throw new RuntimeException("El fragmento debe implementar OnFabClickListener");
            }
        }
    }

    @Override
    public void navigateToNextVisitsFragment() {
        // TODO
        Toast.makeText(this, "Próximas visitas", Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void navigateToVisitActivity() {
        // TODO
        Toast.makeText(this, "Nueva visita", Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

}
