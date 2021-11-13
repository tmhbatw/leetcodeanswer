package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int pre=0;
        for(int num:arr){
            if(num>pre)
                pre++;
        }
        return pre;
    }
}
