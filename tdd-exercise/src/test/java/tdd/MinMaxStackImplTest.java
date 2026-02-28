package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private SimpleMinMaxStack simpleMinMaxStack;

    @BeforeEach
    void beforeEach(){
        simpleMinMaxStack = new SimpleMinMaxStack();
    }

    @Test
    public void testInitialState() {
        assertTrue(simpleMinMaxStack.isEmpty());
        assertEquals(0, simpleMinMaxStack.size());
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.getMin()); // empty stack
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.getMax()); // empty stack
    }

    @Test
    public void testEmpty() {
        assertTrue(simpleMinMaxStack.isEmpty());
        simpleMinMaxStack.push(3);
        assertFalse(simpleMinMaxStack.isEmpty());
    }

    @Test
    public void testPush() {
        assertTrue(simpleMinMaxStack.isEmpty());
        simpleMinMaxStack.push(3);
        assertEquals(1, simpleMinMaxStack.size());
        simpleMinMaxStack.push(-1);
        assertEquals(2, simpleMinMaxStack.size());
    }

    @Test
    public void testPop() {
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.pop()); // empty stack
        simpleMinMaxStack.push(3);
        simpleMinMaxStack.push(2);
        simpleMinMaxStack.push(10);
        assertEquals(10, simpleMinMaxStack.pop());
    }

    @Test
    public void testSize() {
        assertEquals(0, simpleMinMaxStack.size()); // empty stack

        simpleMinMaxStack.push(3);
        simpleMinMaxStack.push(2);
        simpleMinMaxStack.push(10);
        simpleMinMaxStack.push(8);
        assertEquals(4, simpleMinMaxStack.size());

        simpleMinMaxStack.pop();
        simpleMinMaxStack.peek();
        assertEquals(3, simpleMinMaxStack.size());
    }

    @Test
    public void testPeek() {
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.peek()); // empty stack

        simpleMinMaxStack.push(3);
        simpleMinMaxStack.push(2);
        simpleMinMaxStack.push(10);
        simpleMinMaxStack.push(8);
        assertEquals(8, simpleMinMaxStack.peek());
        assertEquals(8, simpleMinMaxStack.peek());
    }

    @Test
    public void testGetMin() {
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.getMin()); // empty stack

        simpleMinMaxStack.push(3); // single item
        assertEquals(3, simpleMinMaxStack.getMin());

        simpleMinMaxStack.push(2); // new min
        assertEquals(2, simpleMinMaxStack.getMin());

        simpleMinMaxStack.push(6); // new item (not min)
        assertEquals(2, simpleMinMaxStack.getMin());
    }

    @Test
    public void testGetMax() {
        assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.getMax()); // empty stack

        simpleMinMaxStack.push(3); // single item
        assertEquals(3, simpleMinMaxStack.getMax());

        simpleMinMaxStack.push(6); // new max
        assertEquals(6, simpleMinMaxStack.getMax());

        simpleMinMaxStack.push(0); // new item (not max)
        assertEquals(6, simpleMinMaxStack.getMax());
    }

}