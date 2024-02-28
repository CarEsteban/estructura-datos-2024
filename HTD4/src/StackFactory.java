public class StackFactory {

    public enum StackType {
        ARRAY_LIST, 
        VECTOR, 
        SIMPLE_LIST, 
        DOUBLE_LIST
    }

    public static <T> IStack<T> createStack(StackType type) {
        LinkedListFactory<T> linkedListFactory = new LinkedListFactory<>();

        switch (type) {
            case ARRAY_LIST:
                return new StackWithArrayList<T>();
            case VECTOR:
                return new StackWithVector<T>();
            case SIMPLE_LIST:
                return LinkedListFactory.createList(LinkedListFactory.ListType.SIMPLE_LIST);
            case DOUBLE_LIST:
                return LinkedListFactory.createList(LinkedListFactory.ListType.DOUBLE_LIST);
            default:
                throw new IllegalArgumentException("Invalid Stack Type");
        }
    }
}
