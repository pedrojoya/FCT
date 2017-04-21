package es.iessaladillo.pedrojoya.fct.alumnos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.Optional;
import es.iessaladillo.pedrojoya.fct.R;

public class AlumnosFragment extends Fragment {

    @Arg
    @Optional
    String title;

    public AlumnosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alumnos, container, false);
        ActivityStarter.fill(this);
        return rootView;
    }

}
