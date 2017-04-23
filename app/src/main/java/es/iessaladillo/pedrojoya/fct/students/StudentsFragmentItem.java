package es.iessaladillo.pedrojoya.fct.students;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lucasurbas.listitemview.ListItemView;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iessaladillo.pedrojoya.fct.R;
import es.iessaladillo.pedrojoya.fct.model.entities.Student;

public class StudentsFragmentItem extends AbstractItem<StudentsFragmentItem, StudentsFragmentItem
        .ViewHolder> {

    private Student mStudent;

    public StudentsFragmentItem(Student student) {
        this.mStudent = student;
    }

    public Student getStudent() {
        return mStudent;
    }

    @Override
    public int getType() {
        return R.id.lstStudents;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_students_item;
    }

    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        super.bindView(viewHolder, payloads);
        viewHolder.bind(mStudent);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.unBind();
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_view)
        ListItemView listItemView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(Student student) {
            listItemView.setTitle(student.getSirname());
            listItemView.setSubtitle(student.getFirstname());
        }

        public void unBind() {
            listItemView.setTitle(null);
            listItemView.setSubtitle(null);
        }

    }

}
