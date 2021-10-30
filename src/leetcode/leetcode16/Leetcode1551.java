package leetcode.leetcode16;

public class Leetcode1551 {


    public int minOperations(int n) {
        if(n%2==1)
            return (n+1)/2*(n/2);
        return n/2*n/2;
    }
}
