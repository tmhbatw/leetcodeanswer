package leetcode.leetcode27;

import java.util.Arrays;

public class Leetcode2643 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            if (sum > result[1]) {
                result[0] = i;
                result[1] = sum;
            }
        }
        return result;
    }

}
