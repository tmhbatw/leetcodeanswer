package leetcode.leetcode26;

import java.util.Arrays;

public class Leetcode2545 {

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> {
            return o2[k] - o1[k];
        });
        return score;
    }

}
