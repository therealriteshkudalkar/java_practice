package problem80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem80Test {

    @Test
    void testMinStack() {
        Problem80.MinStack stack1 = new Problem80.MinStack();
        stack1.push(-2);
        stack1.push(0);
        stack1.push(-3);
        assertEquals(-3, stack1.getMin()); // return -3
        stack1.pop();
        assertEquals(0, stack1.top());    // return 0
        assertEquals(-2, stack1.getMin()); // return -2

    }
}