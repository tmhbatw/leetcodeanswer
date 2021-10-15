package leetcode.leetcode14;

public class Leetcode1304 {
    public int[] sumZero(int n) {
        int[] res=new int[n];
        for(int i=0;i<n-1;i++)
            res[i]=i+1;
        res[n-1]=-(n-1)*(n)/2;
        return res;
    }
}
