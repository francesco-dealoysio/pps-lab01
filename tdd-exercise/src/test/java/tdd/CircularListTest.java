package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private SimpleCircularQueue simpleCircularQueue;

    @BeforeEach
    void beforeEach(){
        simpleCircularQueue = new SimpleCircularQueue(5);
    }

    @Test
    public void testInitialState() {
        assertEquals(5, simpleCircularQueue.size());
        assertTrue(simpleCircularQueue.isEmpty());
    }

    @Test
    public void testEnqueue() {
        simpleCircularQueue.enqueue(3);
        simpleCircularQueue.enqueue(6);
        simpleCircularQueue.enqueue(-10);
        simpleCircularQueue.enqueue(-54);
        simpleCircularQueue.enqueue(-100); // from here circular queue is full

        assertThrows(IllegalStateException.class,  () -> simpleCircularQueue.enqueue(2)); // full
    }

    @Test
    public void testDequeue() {
        simpleCircularQueue.enqueue(3);
        simpleCircularQueue.enqueue(6);
        simpleCircularQueue.enqueue(-10);
        assertEquals(3, simpleCircularQueue.dequeue());

        simpleCircularQueue.dequeue();
        simpleCircularQueue.dequeue(); // here empty queue
        assertThrows(IllegalStateException.class,  () -> simpleCircularQueue.dequeue()); // empty queue
    }

    @Test
    public void testPeek() {
        simpleCircularQueue.enqueue(-10);
        simpleCircularQueue.enqueue(-54);
        simpleCircularQueue.enqueue(-100);
        assertEquals(-10, simpleCircularQueue.peek());

        simpleCircularQueue.dequeue();
        simpleCircularQueue.dequeue();
        simpleCircularQueue.dequeue(); // here empty queue
        assertThrows(IllegalStateException.class,  () -> simpleCircularQueue.peek()); // empty queue
    }

    @Test
    public void testEmpty() {
        assertTrue(simpleCircularQueue.isEmpty());
        simpleCircularQueue.enqueue(-10);
        assertFalse(simpleCircularQueue.isEmpty());
    }

    @Test
    public void testFull() {
        assertFalse(simpleCircularQueue.isFull());

        simpleCircularQueue.enqueue(3);
        simpleCircularQueue.enqueue(6);
        simpleCircularQueue.enqueue(-10);
        assertFalse(simpleCircularQueue.isFull());

        simpleCircularQueue.enqueue(-54);
        simpleCircularQueue.enqueue(-100); // from here circular queue is full
        assertTrue(simpleCircularQueue.isFull());
    }

    @Test
    public void testSize() {
        assertEquals(5, simpleCircularQueue.size());
    }

    @Test
    public void testCount() {
        assertEquals(0, simpleCircularQueue.count());

        simpleCircularQueue.enqueue(3);
        simpleCircularQueue.enqueue(6);
        simpleCircularQueue.enqueue(-10);
        assertEquals(3, simpleCircularQueue.count());

        simpleCircularQueue.dequeue();
        assertEquals(2, simpleCircularQueue.count());

        simpleCircularQueue.clear();
        assertEquals(0, simpleCircularQueue.count());
    }

    @Test
    public void testClear() {
        simpleCircularQueue.enqueue(3);
        simpleCircularQueue.enqueue(6);
        simpleCircularQueue.enqueue(-10);
        assertFalse(simpleCircularQueue.isEmpty());

        simpleCircularQueue.clear();
        assertTrue(simpleCircularQueue.isEmpty());
    }

}
