package leetcode.leetcode24;

public class Leetcode2369 {

    public boolean validPartition(int[] nums) {
        boolean[] result=new boolean[nums.length+1];
        result[0]=true;
        if(nums[0]==nums[1])
            result[2]=true;

        for(int i=2;i<nums.length;i++){
            if(nums[i]==nums[i-1]&&result[i-1])
                result[i+1]=true;
            if((nums[i]==nums[i-1]&&nums[i]==nums[i-2]||
                nums[i]-nums[i-1]==1&&nums[i]-nums[i-2]==2)&&result[i-2])
                result[i+1]=true;
        }
        return result[nums.length];
    }


}
