package tdd;
import tdd.SimpleSmartDoorLock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SimpleSmartDoorLock simpleSmartDoorLock;

    @BeforeEach
    void beforeEach(){
        simpleSmartDoorLock = new SimpleSmartDoorLock();
    }

    @Test
    public void testInitialState() {
        assertTrue(simpleSmartDoorLock.isNoPin());
        //assertFalse(simpleSmartDoorLock.isOpen());
        assertFalse(simpleSmartDoorLock.isLocked());
        assertFalse(simpleSmartDoorLock.isBlocked());
        assertEquals(3, simpleSmartDoorLock.getMaxAttempts());
        assertEquals(0, simpleSmartDoorLock.getFailedAttempts());
    }

    @Test
    public void testSuccessLocking() {
        simpleSmartDoorLock.setPin(123);
        simpleSmartDoorLock.lock();
        assertFalse(simpleSmartDoorLock.isNoPin());
        assertTrue(simpleSmartDoorLock.isLocked());
    }

    @Test
    public void testFailedLocking() {
        simpleSmartDoorLock.setPin(-1345); // under bound (negative) pin value
        assertTrue(simpleSmartDoorLock.isNoPin());
        assertThrows(IllegalStateException.class,  () -> simpleSmartDoorLock.lock());

        simpleSmartDoorLock.setPin(-1345); // upper bound pin value
        assertTrue(simpleSmartDoorLock.isNoPin());
        assertThrows(IllegalStateException.class,  () -> simpleSmartDoorLock.lock());
    }

    @Test
    public void testSuccessUnlocking() {
        simpleSmartDoorLock.setPin(0);  // minimum range pin value
        simpleSmartDoorLock.lock();
        assertTrue(simpleSmartDoorLock.isLocked());
        simpleSmartDoorLock.unlock(0);
        assertFalse(simpleSmartDoorLock.isLocked());

        simpleSmartDoorLock.setPin(5470);   // in range pin value
        simpleSmartDoorLock.lock();
        assertTrue(simpleSmartDoorLock.isLocked());
        simpleSmartDoorLock.unlock(5470);
        assertFalse(simpleSmartDoorLock.isLocked());

        simpleSmartDoorLock.setPin(9999);   // maximum range pin value
        simpleSmartDoorLock.lock();
        assertTrue(simpleSmartDoorLock.isLocked());
        simpleSmartDoorLock.unlock(9999);
        assertFalse(simpleSmartDoorLock.isLocked());
    }

    @Test
    public void testSuccessBlocking() {
        simpleSmartDoorLock.setPin(123);
        simpleSmartDoorLock.lock();
        simpleSmartDoorLock.unlock(124);
        simpleSmartDoorLock.unlock(122);
        simpleSmartDoorLock.unlock(350);
        simpleSmartDoorLock.unlock(122);  // here system will be blocked
        simpleSmartDoorLock.unlock(9998); // attempt beyond the block, failed attempts don't increase
        assertEquals(4, simpleSmartDoorLock.getFailedAttempts());
        assertTrue(simpleSmartDoorLock.isLocked());
        assertTrue(simpleSmartDoorLock.isBlocked());

    }

    @Test
    public void testSuccessReset() {
        simpleSmartDoorLock.setPin(123);
        simpleSmartDoorLock.lock();
        simpleSmartDoorLock.unlock(124);
        simpleSmartDoorLock.unlock(122);
        simpleSmartDoorLock.unlock(350);
        simpleSmartDoorLock.unlock(122);  // here system will be blocked
        assertTrue(simpleSmartDoorLock.isBlocked());

        simpleSmartDoorLock.unlock(123); // system remains still blocked
        assertTrue(simpleSmartDoorLock.isBlocked());

        simpleSmartDoorLock.reset(); // system unblocked
        assertFalse(simpleSmartDoorLock.isBlocked());
    }
}
