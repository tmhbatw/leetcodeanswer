package leetcode.leetcode14;

public class Leetcode1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] sum=new int[arr.length+1];
        for(int i=0;i<arr.length;i++)
            sum[i+1] = sum[i]^arr[i];
        int[] res=new int[queries.length];
        for(int i=0;i<res.length;i++)
            res[i]=sum[queries[i][1]+1]^sum[queries[i][0]];
        return res;
    }
}
