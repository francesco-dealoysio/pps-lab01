import tdd.SimpleCircularQueue;
import tdd.SimpleMinMaxStack;
import tdd.SimpleSmartDoorLock;

public class Main {
    public static void main(String[] args) {
        SimpleSmartDoorLock simpleSmartDoorLock;
        SimpleMinMaxStack simpleMinMaxStack;
        SimpleCircularQueue simpleCircularQueue;

        System.out.println("\n - Lab_01 Step_1: SmartDoorLock created!");
        simpleSmartDoorLock = new SimpleSmartDoorLock();
        System.out.println("" + simpleSmartDoorLock);

        System.out.println("\n - Lab_01 Step_2: MinMaxStack created!");
        simpleMinMaxStack = new SimpleMinMaxStack();
        System.out.println("" + simpleMinMaxStack);

        System.out.println("\n - Lab_01 Step_3: Circular Queue created!");
        simpleCircularQueue = new SimpleCircularQueue(5);
        System.out.println(simpleCircularQueue.toString());

    }
}
