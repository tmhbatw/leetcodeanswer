package leetcode.leetcode29;

import java.util.List;

public class Leetcode2855 {

    public int minimumRightShifts(List<Integer> nums) {
        if (getRes(nums, 0)) {
            return 0;
        }
        for (int j = nums.size() - 1; j >= 0; j--) {
            if (getRes(nums, j)) {
                return nums.size() - j;
            }
        }
        return -1;
    }

    private Boolean getRes(List<Integer> nums, int start) {

        for (int i = 1; i < nums.size(); i++) {
            int pre = (i - 1 + start) % nums.size();
            int cur = (i + start) % nums.size();
            if (nums.get(cur) < nums.get(pre)) {
                return false;
            }
        }
        return true;
    }


}
