public class LinkedListFactory<T> {

    public enum ListType {
        SIMPLE_LIST,
        DOUBLE_LIST
    }

    public static <T> IStack<T> createList(ListType type) {
        switch (type) {
            case SIMPLE_LIST:
                return new SimpleList<T>();
            case DOUBLE_LIST:
                return new DoubleList<T>();
            default:
                throw new IllegalArgumentException("Invalid List Type");
        }
    }
}