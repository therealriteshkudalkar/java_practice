package problem9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {

    @Test
    void permutationWithoutRepetition() {
        Problem9 pb = new Problem9();
        List<String> list = pb.permutationWithoutRepetition("abc");
        System.out.println(list);
        List<String> confirmatoryList = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        assertEquals(confirmatoryList, list);
    }

    @Test
    void permutationWithoutRepetition1() {
        Problem9 pb = new Problem9();
        List<String> list = pb.permutationWithoutRepetition("abcd");
        System.out.println(list);
        List<String> confirmatoryList = Arrays.asList("abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc",
                "bcad", "bcda", "bdac", "bdca", "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac",
                "dbca", "dcab", "dcba");
        assertEquals(confirmatoryList, list);
    }

    @Test
    void permutationWithRepetition() {
        Problem9 pb = new Problem9();
        List<String> list = pb.permutationWithRepetition("abc");
        System.out.println(list);
        List<String> confirmatoryList = Arrays.asList("aaa", "aab", "aac", "aba", "abb", "abc", "aca", "acb", "acc",
                "baa", "bab", "bac", "bba", "bbb", "bbc", "bca", "bcb", "bcc", "caa", "cab", "cac", "cba", "cbb", "cbc",
                "cca", "ccb", "ccc");
        assertEquals(confirmatoryList, list);
    }
}