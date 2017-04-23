package es.iessaladillo.pedrojoya.fct.students;

import es.iessaladillo.pedrojoya.fct.model.entities.Student;

class StudentsPresenter implements StudentsContract.Presenter {

    StudentsContract.View mView;

    public StudentsPresenter(StudentsContract.View view) {
        this.mView = view;
    }

    @Override
    public void onViewAttach(StudentsContract.View view) {
        mView = view;
    }

    @Override
    public void onViewDetach() {
    }

    @Override
    public void onDestroy() {
        mView = new StudentsContract.View() {
            @Override
            public void navigateToStudentActivity() {
            }

            @Override
            public void navigateToStudentActivity(Student student) {

            }
        };
    }

    @Override
    public StudentsContract.View getView() {
        return mView;
    }

    @Override
    public void doOnFabClick() {
        mView.navigateToStudentActivity();
    }

    @Override
    public void doOnItemClick(Student student) {
        mView.navigateToStudentActivity(student);
    }

}
