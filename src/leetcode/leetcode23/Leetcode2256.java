package leetcode.leetcode23;

public class Leetcode2256 {

    public int minimumAverageDifference(int[] nums) {
        long result = Long.MAX_VALUE;
        int res = 0;
        long sum=0;
        for(int num:nums)
            sum+=num;

        long cur=0;
        for(int i=0;i<nums.length;i++){
            cur += nums[i];
            sum -= nums[i];

            long curr =Math.abs(getResult(cur,i+1)-
                    getResult(sum,nums.length-i-1));
            System.out.println(curr+" "+i);
            if(curr<result){
                result = curr;
                res = i;
            }
        }

        return res;
    }

    public long getResult(long sum, int time){
        if(time==0)
            return 0;

        return sum/time;
    }
}
