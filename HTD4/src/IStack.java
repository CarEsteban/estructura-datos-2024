public interface IStack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    T peek(); 
    int size();
}