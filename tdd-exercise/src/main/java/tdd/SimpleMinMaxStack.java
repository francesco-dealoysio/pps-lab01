package tdd;

import java.util.Vector;
import tdd.Util;

public class SimpleMinMaxStack implements MinMaxStack {
    //private int[] intStack;
    private Vector<Integer> intStack;
    private int[] sortedVector = {};
    private int items;

    public SimpleMinMaxStack() {
        intStack = new Vector<>();
        this.items = 0;
    }

    @Override
    public void push(int value) {
        intStack.add(value);

        items++;
        sortedVector = Util.intVectorSortedInsertItem(sortedVector, value);
    }

    @Override
    public int pop() {
        int result;

        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        result = this.intStack.lastElement();
        this.intStack.remove(size() - 1);
        items--;

        sortedVector = Util.intVectorSortedRemoveItem(sortedVector, result);

        return result;
    }

    @Override
    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return this.intStack.lastElement();
    }

    @Override
    public int getMin() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return this.sortedVector[0];
    }

    @Override
    public int getMax() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        //return this.max;
        return this.sortedVector[sortedVector.length-1];
    }

    @Override
    public boolean isEmpty() {
        return (this.items == 0);
    }

    @Override
    public int size() {
        return this.items;
    }

    public String toString() {
        String message = "";
        String line = "-".repeat(40);
        int [] stack = intStack.stream().mapToInt(i -> (i != null) ? i : 0).toArray();

        message += line + "\n";
        message += "Stack.......: " + Util.displayIntVector(stack) + "\n";
        message += "Sorted stack: " + Util.displayIntVector(sortedVector) + "\n";
        message += "Size........: " + items + "\n";
        message += "Min.........: " + ((size() == 0) ? "-" : getMin()) + "\n";
        message += "Max.........: " + ((size() == 0) ? "-" : getMax())+ "\n";
        message += line;

        return message;
    }

    public static void main(String[] args) {
        int value;
        SimpleMinMaxStack simpleMinMaxStack;

        System.out.println("\n - MinMaxStack created!");
        simpleMinMaxStack = new SimpleMinMaxStack();
        System.out.println("" + simpleMinMaxStack);

        //System.out.println("Peek: " + simpleMinMaxStack.peek()); // throws exception

        value = 3;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 7;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 5;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 10;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(" - Executed peek: " + simpleMinMaxStack.peek());
        System.out.println("" + simpleMinMaxStack);

        value = 3;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);
        System.out.println(simpleMinMaxStack.toString());

        value = 3;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 1;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 10;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = 7;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        value = -5;
        System.out.println(" - Executed push: " + value);
        simpleMinMaxStack.push(value);

        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        System.out.println(" - Executed pop: " + simpleMinMaxStack.pop());
        System.out.println(simpleMinMaxStack.toString());

        //System.out.println(" - Executed pop: " + simpleMinMaxStack.pop()); // throws exception
        //System.out.println(simpleMinMaxStack.toString());

    }
}
