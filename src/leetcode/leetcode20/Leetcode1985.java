package leetcode.leetcode20;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode1985 {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,(o1,o2)->{
            if(o1.length()<o2.length())
                return -1;
            if(o2.length()<o1.length())
                return 1;
            for(int i=0;i<o1.length();i++){
                if(o1.charAt(i)==o2.charAt(i))
                    continue;
                return o1.charAt(i)-o2.charAt(i);
            }
            return 0;
        });


        return nums[nums.length-k];
    }
}
