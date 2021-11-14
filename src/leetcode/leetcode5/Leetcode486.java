package leetcode.leetcode5;

public class Leetcode486 {

    public boolean PredictTheWinner(int[] nums) {
        int length=nums.length;
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++){
            sum[i+1]=sum[i]+nums[i];
        }

        int[][] res=new int[length][length];
        for(int i=0;i<length;i++){
            res[i][i]=nums[i];
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                res[i][j]=Math.max(nums[i]+sum[j+1]-sum[i+1]-res[i+1][j],
                        nums[j]+sum[j]-sum[i]-res[i][j-1]);
            }
        }
        return res[0][length-1]+res[0][length-1]>=sum[length];
    }
}
