import tdd.SimpleSmartDoorLock;

public class Main {
    public static void main(String[] args) {
        SimpleSmartDoorLock simpleSmartDoorLock = new SimpleSmartDoorLock();

        simpleSmartDoorLock.setPin(123);
        simpleSmartDoorLock.lock();
        simpleSmartDoorLock.unlock(123);
        simpleSmartDoorLock.unlock(124);
        simpleSmartDoorLock.unlock(124);
        simpleSmartDoorLock.unlock(124);

        System.out.println(simpleSmartDoorLock.getFailedAttempts());
        System.out.println(simpleSmartDoorLock.isBlocked());
    }
}
