package leetcode.leetcode9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode888 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int diff= (Arrays.stream(aliceSizes).sum()-Arrays.stream(bobSizes).sum())/2;
        Set<Integer> set=new HashSet<>();
        for(int cur:bobSizes)
            set.add(cur);
        for(int cur:aliceSizes){
            if(set.contains(cur-diff))
                return new int[]{cur,cur-diff};
        }
        return null;
    }
}
