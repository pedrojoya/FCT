package es.iessaladillo.pedrojoya.fct.students;

import es.iessaladillo.pedrojoya.fct.base.BasePresenter;
import es.iessaladillo.pedrojoya.fct.model.entities.Student;

public interface StudentsContract {

    interface Presenter extends BasePresenter<View> {
        void doOnFabClick();

        void doOnItemClick(Student student);
    }

    interface View {
        void navigateToStudentActivity();

        void navigateToStudentActivity(Student student);
    }

}
