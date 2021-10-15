package leetcode.leetcode15;

public class Leetcode1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int pre=0;
        for(;pre<nums.length;pre++){
            if(nums[pre]==1)
                break;
        }
        for(int i=pre+1;i<nums.length;i++){
            if(nums[i]==1){
                if(i-pre<=k)
                    return false;
                pre=i;
            }
        }
        return true;
    }
}
