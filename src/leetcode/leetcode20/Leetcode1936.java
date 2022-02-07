package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1936 {
    public int addRungs(int[] rungs, int dist) {
        int result=(rungs[0]-1)/dist;

        for(int i=1;i<rungs.length;i++){
            result+=(rungs[i]-rungs[i-1]-1)/dist;
        }

        return result;
    }
}
