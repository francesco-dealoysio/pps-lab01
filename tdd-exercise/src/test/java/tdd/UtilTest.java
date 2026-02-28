package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {

    private int[] vet = {};

    @BeforeEach
    void beforeEach(){}

    @Test
    public void testInitialState() {
        assertTrue(true);
        //assertEquals(0, simpleMinMaxStack.size());
        //assertThrows(IllegalStateException.class,  () -> simpleMinMaxStack.getMin()); // empty stack
    }

}
