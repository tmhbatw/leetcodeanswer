package leetcode.leetcode21;

public class Leetcode2012 {

    public int sumOfBeauties(int[] nums) {
        int[] max=new int[nums.length];
        int cur = 0;
        for(int i=0;i<nums.length;i++){
            cur=Math.max(cur,nums[i]);
            max[i]=cur;
        }

        int result = 0;
        cur = nums[nums.length-1];
        for(int j=nums.length-2;j>=1;j--){
            if(nums[j]<cur&&nums[j]>max[j-1])
                result+=2;
            else if(nums[j]<nums[j+1]&&nums[j]>nums[j-1])
                result++;

            //System.out.println(j+" "+result);
            cur=Math.min(cur,nums[j]);
        }

        return result;
    }
}
