import java.util.ArrayList;

public class StackWithArrayList<T> implements IStack<T> {
    private ArrayList<T> stack;

    public StackWithArrayList() {
        this.stack = new ArrayList<>();
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
