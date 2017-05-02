package es.iessaladillo.pedrojoya.fct.students;

import android.text.TextUtils;

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
        mView = new StudentsContract.View() {
            @Override
            public void navigateToStudentActivity() {
            }

            @Override
            public void navigateToStudentActivity(Student student) {

            }

            @Override
            public void navigateToDialActivity(String phonenumber) {

            }

            @Override
            public void navigateToVisitsActivity(Student student) {

            }

            @Override
            public void showErrorNoPhonenumber() {

            }
        };
    }

    @Override
    public void onDestroy() {
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

    @Override
    public void doOnItemCallClick(Student student) {
        if (!TextUtils.isEmpty(student.getPhonenumber())) {
            mView.navigateToDialActivity(student.getPhonenumber());
        } else {
            mView.showErrorNoPhonenumber();
        }
    }

    @Override
    public void doOnItemVisitsClick(Student student) {
        mView.navigateToVisitsActivity(student);
    }

}
