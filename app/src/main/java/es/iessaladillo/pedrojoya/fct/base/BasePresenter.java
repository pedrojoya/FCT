package es.iessaladillo.pedrojoya.fct.base;

@SuppressWarnings({"EmptyMethod", "unused"})
public interface BasePresenter<V> {
    void onViewAttach(V view);
    void onViewDetach();
    void onDestroy();
    V getView();
}
