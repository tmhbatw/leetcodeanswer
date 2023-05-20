package leetcode.leetcode27;

public class Leetcode2600 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes)
            return k;
        return numOnes - Math.max(0, k - numOnes - numZeros);
    }
}
