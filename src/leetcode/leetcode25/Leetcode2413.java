package leetcode.leetcode25;

public class Leetcode2413 {

    public int smallestEvenMultiple(int n) {
        return (n&1)==0?n:2*n;
    }

}
