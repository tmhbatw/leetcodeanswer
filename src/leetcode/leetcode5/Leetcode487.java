package leetcode.leetcode5;

public class Leetcode487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0;
        int pre0=0;

        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==0){
                if(i>=1&&nums[i-1]==0)
                    pre0=0;
                continue;
            }
            int start=i;
            while(i<length-1&&nums[i+1]==1)
                i++;
            int cur0=i-start+1;
            result=Math.max(cur0+pre0+1,result);
            pre0=cur0;
        }
        if(result==0)
            return Math.min(length,1);

        return Math.min(length,result);
    }
}
