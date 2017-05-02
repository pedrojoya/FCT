package es.iessaladillo.pedrojoya.fct.students;

import android.support.annotation.NonNull;

import es.iessaladillo.pedrojoya.fct.base.BasePresenter;
import es.iessaladillo.pedrojoya.fct.model.entities.Student;

public interface StudentsContract {

    interface Presenter extends BasePresenter<View> {
        void doOnFabClick();

        void doOnItemClick(Student student);

        void doOnItemCallClick(Student student);

        void doOnItemVisitsClick(Student student);
    }

    interface View {
        void navigateToStudentActivity();

        void navigateToStudentActivity(@NonNull Student student);

        void navigateToDialActivity(@NonNull String phonenumber);

        void navigateToVisitsActivity(@NonNull Student student);

        void showErrorNoPhonenumber();
    }

}
