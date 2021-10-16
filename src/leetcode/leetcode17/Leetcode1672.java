package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1672 {
    public int maximumWealth(int[][] accounts) {
        int result=0;
        for(int[] cur:accounts){
            result=Math.max(result, Arrays.stream(cur).sum());
        }
        return result;
    }
}
