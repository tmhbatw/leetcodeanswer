package leetcode.leetcode18;

public class Leetcode1752 {
    public boolean check(int[] nums) {
        int length=nums.length;
        for(int i=0;i<nums.length;i++) {
            int pre = nums[i];
            boolean flag = true;
            for (int j = 1; j < length && flag; j++) {
                int index = (i + j) % length;
                if (nums[index] < pre)
                    flag = false;
                pre = nums[index];
            }
            if (flag)
                return true;
        }
        return false;
    }
}
