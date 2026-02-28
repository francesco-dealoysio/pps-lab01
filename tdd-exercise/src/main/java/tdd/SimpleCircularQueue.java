package tdd;

public class SimpleCircularQueue implements CircularQueue {
    private final int capacity;
    private int[] circularQueue;
    private int front; // position index for the element to be dequeued
    private int rear; // position index for the element to be enqueued

    public SimpleCircularQueue(int capacity) {
        this.capacity = capacity;
        this.circularQueue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enqueue(int value) {

        if (this.isFull()) {
            throw new IllegalStateException("Circular Queue is full!");
        }

        if (this.isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear+1) % capacity;
        }

        circularQueue[rear] = value;
    }

    @Override
    public int dequeue() {
        int result;

        if (this.isEmpty()) {
            throw new IllegalStateException("Circular Queue is empty!");
        }

        result = circularQueue[front];
        circularQueue[front] = 0;
        front = (front+1) % capacity;

        if (((rear + 1) % capacity) == front) { // it was the last element
            front = -1;
            rear = -1;
        }

        return result;
    }

    @Override
    public int peek() {

        if (this.isEmpty()) {
            throw new IllegalStateException("Circular Queue is empty!");
        }

        return circularQueue[front];
    }

    @Override
    public boolean isEmpty() {
        return ((front == -1) && (rear == -1));
    }

    @Override
    public boolean isFull() {
        return ((rear+1) % capacity == front);
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public int count() {
        int result = 0;
        int front_scratch = front;

        if (!((front_scratch == -1) && (rear == -1))) { // check for not empty queue
            result++;
            while(front_scratch != rear) {
                result++;
                front_scratch = ((front_scratch+1) % capacity);
            }
        }

        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < circularQueue.length; i++) {
            circularQueue[i] = 0;
        }
        front = -1;
        rear = -1;
    }

    public String toString() {
        String message = "";
        String line = "-".repeat(40);

        message += line + "\n";
        message += "Circular queue : " + Util.displayIntVector(circularQueue) + "\n";
        message += "Capacity.......: " + capacity + "\n";
        message += "Number of items: " + count() + "\n";
        message += "Front index....: " + front + "\n";
        message += "Rear index.....: " + rear + "\n";
        message += line;

        return message;
    }

    public static void main(String[] args) {
        int value;
        SimpleCircularQueue simpleCircularQueue;

        System.out.println("\n - Circular Queue created!");
        simpleCircularQueue = new SimpleCircularQueue(5);
        System.out.println(simpleCircularQueue.toString());

        value = 3;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = 6;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = -10;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = -54;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = -100;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        // simpleCircularQueue.enqueue(2); // here throws exception
        System.out.println(simpleCircularQueue.toString());

        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(simpleCircularQueue.toString());

        value = 50;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);
        System.out.println(simpleCircularQueue.toString());

        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(simpleCircularQueue.toString());

        System.out.println(" - Executed dequeue: " + simpleCircularQueue.dequeue());
        System.out.println(simpleCircularQueue.toString());

        value = -10;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = -54;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);

        value = -100;
        System.out.println(" - Executed enqueue: " + value);
        simpleCircularQueue.enqueue(value);
        System.out.println(simpleCircularQueue.toString());

        System.out.println("Executed Peek: " + simpleCircularQueue.peek());

        simpleCircularQueue.clear();
        System.out.println("Executed Clear!");

        System.out.println(simpleCircularQueue.toString());

    }
}