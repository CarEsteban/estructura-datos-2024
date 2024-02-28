public interface IListBasedStack<T> extends IStack<T> {
    void add(T item);
    T remove(int index);
    T get(int index);
}
