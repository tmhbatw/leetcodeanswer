package leetcode.leetcode9;

public class Leetcode810 {

    public boolean xorGame(int[] nums) {
        if(nums.length%2==0)
            return true;
        int res=0;
        for(int cur:nums)
            res^=cur;
        return res==0;
    }
}
