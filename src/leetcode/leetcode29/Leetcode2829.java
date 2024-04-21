package leetcode.leetcode29;

public class Leetcode2829 {

    public int minimumSum(int n, int k) {
        int maxNumberSmallerThanK = k/2;
        if(n<=maxNumberSmallerThanK){
            return n*(n+1)/2;
        }
        return maxNumberSmallerThanK*(maxNumberSmallerThanK+1)/2+(n-maxNumberSmallerThanK+k+k-1)*(n-maxNumberSmallerThanK)/2;
    }

}
