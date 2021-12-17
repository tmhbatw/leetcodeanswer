package leetcode.leetcode7;

public class Leetcode644 {

    public double findMaxAverage(int[] nums, int k) {
        double l=-10000,r=10000;

        while(r-l>0.000001){
            double mid=(r+l)/2;
            if(isMatch(nums,k,mid))
                l=mid;
            else
                r=mid;
        }
        return l;
    }

    private boolean isMatch(int[] nums,int k,double mid){
        double[] num=new double[nums.length];
        for(int i=0;i<num.length;i++)
            num[i]=nums[i]-mid;

        double pre=0;
        double[] sum=new double[num.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=num[i]+sum[i];
            if(i>=k-1){
                pre=Math.min(pre,sum[i+1-k]);

                if(sum[i+1]>pre)
                    return true;
            }
        }
        return false;
    }
}
