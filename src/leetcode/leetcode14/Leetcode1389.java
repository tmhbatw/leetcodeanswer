package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            result.add(index[i],nums[i]);
        for(int i=0;i<nums.length;i++)
            nums[i]=result.get(i);
        return nums;
    }
}
