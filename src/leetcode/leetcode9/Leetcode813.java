package leetcode.leetcode9;

public class Leetcode813 {

    public double largestSumOfAverages(int[] nums, int k) {
        int length=nums.length;
        double[][] res=new double[length+1][k+1];

        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+nums[i];

        for(int i=0;i<length;i++){

            res[i+1][1]=(sum[i+1])*1.0/(i+1);
            for(int j=1;j<Math.min(i+1,k);j++){

                for(int l=0;l<=i;l++){
                    res[i+1][j+1]=Math.max(res[i+1][j+1],(sum[i+1]-sum[l])*1.0/(j+1)+res[l][j]);
                }

            }
        }

        return res[length][k];
    }
}
