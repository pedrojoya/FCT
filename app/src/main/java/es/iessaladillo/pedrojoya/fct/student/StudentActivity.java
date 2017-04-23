package es.iessaladillo.pedrojoya.fct.student;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import activitystarter.Arg;
import activitystarter.Optional;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.iessaladillo.pedrojoya.fct.R;
import es.iessaladillo.pedrojoya.fct.model.entities.Student;

public class StudentActivity extends AppCompatActivity {

    @Arg
    String title;

    @Arg
    @Optional
    Student student;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.lblStudent)
    TextView lblStudent;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);
        StudentActivityStarter.fill(this, savedInstanceState);


        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction(
                        "Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (student != null) {
            lblStudent.setText(student.getSirname());
        } else {
            lblStudent.setText(title);
        }
    }

}
