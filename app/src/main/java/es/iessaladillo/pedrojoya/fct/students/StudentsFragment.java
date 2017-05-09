package es.iessaladillo.pedrojoya.fct.students;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.Arrays;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.Optional;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.iessaladillo.pedrojoya.fct.R;
import es.iessaladillo.pedrojoya.fct.components.MessageManager.ToastMessageManager;
import es.iessaladillo.pedrojoya.fct.model.entities.Student;
import es.iessaladillo.pedrojoya.fct.student.StudentActivityStarter;
import es.iessaladillo.pedrojoya.fct.utils.FabUtils;
import es.iessaladillo.pedrojoya.fct.utils.IntentUtils;

public class StudentsFragment extends Fragment implements FabUtils.OnFabClickListener,
        StudentsContract.View, StudentsFragmentItem.Callback {

    @Arg
    @Optional
    String title;

    @BindView(R.id.lstStudents)
    RecyclerView lstStudents;
    @BindView(R.id.emptyView)
    TextView emptyView;
    Unbinder unbinder;

    private StudentsPresenter mPresenter;
    private ToastMessageManager mMessageManager;
    private FastItemAdapter<StudentsFragmentItem> mAdapter;
    private RecyclerView.AdapterDataObserver mEmptyObserver;

    public StudentsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mPresenter = new StudentsPresenter(this);
        mMessageManager = new ToastMessageManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_students, container, false);
        ActivityStarter.fill(this);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewAttach(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        lstStudents.setHasFixedSize(true);
        lstStudents.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        lstStudents.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FastItemAdapter();
        mAdapter.withSelectable(true);
        mAdapter.withOnClickListener((v, adapter, item, position) -> {
            mPresenter.doOnItemClick(item.getStudent());
            return true;
        });
        mEmptyObserver = new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                checkAdapterIsEmpty();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                checkAdapterIsEmpty();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                checkAdapterIsEmpty();
            }
        };
        mAdapter.registerAdapterDataObserver(mEmptyObserver);
        lstStudents.setAdapter(mAdapter);
        // TODO
        mAdapter.add(Arrays.asList(
                new StudentsFragmentItem(new Student("Baldomero", "Llegate Ligero", "666666666"), this),
                new StudentsFragmentItem(new Student("Dolores", "Fuertes de Barriga",
                        "666666666"),
                        this)));
        lstStudents.setAdapter(mAdapter);
    }

    private void checkAdapterIsEmpty() {
        emptyView.setVisibility(mAdapter.getItemCount() == 0 ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onViewDetach();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onFabClick() {
        mPresenter.doOnFabClick();
    }

    @Override
    public void navigateToStudentActivity() {
        StudentActivityStarter.start(getActivity(),
                getString(R.string.activity_student_new_student));
    }

    @Override
    public void navigateToStudentActivity(Student student) {
        StudentActivityStarter.start(getActivity(),
                getString(R.string.activity_student_update_student), student);
    }

    @Override
    public void navigateToDialActivity(String phonenumber) {
        startActivity(IntentUtils.getDialIntent(phonenumber));
    }

    @Override
    public void navigateToVisitsActivity(Student student) {
        // TODO
    }

    @Override
    public void showErrorNoPhonenumber() {
        mMessageManager.showMessage(lstStudents, getString(R.string
                .fragment_students_no_phonenumber));
    }

    @Override
    public void onVisitsMenuItemClick(Student student) {
        mPresenter.doOnItemVisitsClick(student);
    }

    @Override
    public void onCallMenuItemClick(Student student) {
        mPresenter.doOnItemCallClick(student);
    }

}
