package problem89;

import org.junit.jupiter.api.Test;
import problem7.Problem7;

import static org.junit.jupiter.api.Assertions.*;

class Problem89Test {

    @Test
    void bagOfTokensScore() {
        Problem89 problem = new Problem89();

        assertEquals(0, problem.bagOfTokensScore(new int[]{100}, 50));

        assertEquals(1, problem.bagOfTokensScore(new int[]{200, 100}, 150));

        assertEquals(2, problem.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }
}