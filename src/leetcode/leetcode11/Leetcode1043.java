package leetcode.leetcode11;

public class Leetcode1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] res=new int[arr.length+1];
        for(int i=0;i<arr.length;i++){

            for(int j=Math.max(0,i-k+1);j<=i;j++){
                int max=arr[i];
                for(int l=j;l<i;l++){
                    max=Math.max(max,arr[l]);
                }
                res[i+1]=Math.max(res[i+1],res[j]+(i-j+1)*max);
            }
        }
        return res[arr.length];
    }
}
