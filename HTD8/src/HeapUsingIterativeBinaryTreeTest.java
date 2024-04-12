import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HeapUsingIterativeBinaryTreeTest {

    private ComparadorNumeros<Integer> minComparator = new ComparadorNumeros<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    @Test
    public void testInsert() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(minComparator);
        heap.Insert(5, "five");
        heap.Insert(3, "three");
        heap.Insert(9, "nine");

        assertEquals("three", heap.get()); // test if the root is correct after inserts
    }

    @Test
    public void testCount() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(minComparator);
        assertEquals(0, heap.count());

        heap.Insert(5, "five");
        heap.Insert(3, "three");
        assertEquals(2, heap.count());

        heap.remove();
        assertEquals(1, heap.count());

    }

    @Test
    public void testGet() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(minComparator);
        heap.Insert(10, "ten");
        assertEquals("ten", heap.get());

        heap.Insert(1, "one");
        assertEquals("one", heap.get());
    }

    @Test
    public void testIsEmpty() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(minComparator);
        assertTrue(heap.isEmpty());

        heap.Insert(1, "one");
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testRemove() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(minComparator);
        heap.Insert(4, "four");
        heap.Insert(1, "one");
        heap.Insert(3, "three");
        heap.Insert(2, "two");

        assertEquals("one", heap.get());
        assertEquals("one", heap.remove());
        assertEquals("two", heap.get());

        assertEquals("two", heap.remove());
        assertEquals("three", heap.get());

        assertEquals("three", heap.remove());
        assertEquals("four", heap.get());

        assertEquals("four", heap.remove());
        assertTrue(heap.isEmpty());

    }
}
