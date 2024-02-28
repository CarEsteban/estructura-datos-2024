import java.util.Vector;

public class StackWithVector<T> implements IStack<T>{
       private Vector<T> stack;

    public StackWithVector() {
        this.stack = new Vector<>();
    }

    @Override
    public void push(T item) {
        stack.add(item); 
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Vacio");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Vacio");
        }
        return stack.get(stack.size() - 1); 
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty(); 
    }

    @Override
    public int size() {
        return stack.size();
    }

}
