package es.iessaladillo.pedrojoya.fct.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.iessaladillo.pedrojoya.fct.R;
import es.iessaladillo.pedrojoya.fct.alumnos.AlumnosFragmentStarter;
import es.iessaladillo.pedrojoya.fct.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
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
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
        int id = item.getItemId();
        if (id == R.id.mnuAlumnado) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.content_main,
                    AlumnosFragmentStarter.newInstance());
            // TODO Cargar fragmento.
            Toast.makeText(this, "Fragmento de alumnado", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.mnuEmpresas) {
            // TODO Cargar fragmento.
            Toast.makeText(this, "Fragmento de empresas", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.mnuPreferencias) {
            // TODO Cargar fragmento.
            Toast.makeText(this, "Fragmento de preferencias", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        // TODO Llamar a método de fragmento.
        Toast.makeText(this, "Pulsación en FAB", Toast.LENGTH_SHORT).show();
    }

}
