package leetcode.leetcode23;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class Leetcode2229 {
    public boolean isConsecutive(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=1)
                return false;
        }

        return true;
    }
}
