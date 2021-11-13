package leetcode.leetcode11;

public class Leetcode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] sum=new int[1001];
        for(int[] trip:trips){
            sum[trip[1]]+=trip[0];
            sum[trip[2]]-=trip[0];
        }
        int max=sum[0];
        for(int i=1;i<sum.length;i++){
            sum[i]+=sum[i-1];
            max=Math.max(max,sum[i]);
        }
        return max<=capacity;
    }
}
