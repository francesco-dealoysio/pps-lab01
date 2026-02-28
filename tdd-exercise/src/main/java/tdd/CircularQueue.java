package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Insert an integer into rear of the circular queue.
     *
     * @param value The integer to insert.
     * @throws IllegalStateException if the circular queue is full.
     */
    void enqueue(int value);

    /**
     * Removes and returns the front element of the circular queue.
     *
     * @return The dequeued element.
     * @throws IllegalStateException if the circular queue is empty.
     */
    int dequeue();

    /**
     * Retrieves, but does not remove, the front element of the circular queue.
     *
     * @return The front element of the circular queue.
     * @throws IllegalStateException if the circular queue is empty.
     */
    int peek();

    /**
     * Checks if the circular queue is empty.
     *
     * @return true if the circular queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the circular queue is full.
     *
     * @return true if the circular queue is empty, false otherwise.
     */
    boolean isFull();

    /**
     * Gets the capacity of the circular queue.
     *
     * @return The size of the circular queue.
     */
    int size();

    /**
     * Gets the number of elements currently inserted in the circular queue.
     *
     * @return the number of elements of the circular queue.
     */
    int count();

    /**
     * Removes all elements from the circular queue.
     *
     */
    void clear();

}