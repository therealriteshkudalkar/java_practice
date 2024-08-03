package problem11;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {

    @Test
    void printPermutationsWithoutRepetition1() {
        Problem11 pb = new Problem11();
        String str = "abcde";
        pb.printPermutationsWithoutRepetition(str, new HashSet<>(), "");
    }
}