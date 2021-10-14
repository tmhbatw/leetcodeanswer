package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1051 {
    public int heightChecker(int[] heights) {
        int[] height=heights.clone();
        Arrays.sort(height);
        int count=0;
        for(int i=0;i<heights.length;i++)
            if(height[i]!=heights[i]){
                count++;
            }
        return count;
    }
}
