package leetcode.leetcode10;

public class Leetcode961 {

    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 2; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        return -1;
    }

}
