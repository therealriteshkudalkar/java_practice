package problem85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem85Test {

    @Test
    void maximalSquare() {
        Problem85 problem = new Problem85();

        assertEquals(0, problem.maximalSquare(new char[][]{{'0'}}));

        assertEquals(1, problem.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));

        assertEquals(4, problem.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}