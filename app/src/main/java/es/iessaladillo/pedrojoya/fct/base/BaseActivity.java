package es.iessaladillo.pedrojoya.fct.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import activitystarter.ActivityStarter;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStarter.fill(this);
    }

}
