package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result=0;
        for(int j=piles.length-2;j>=piles.length/3;j-=2){
            result+=piles[j];
        }
        return result;
    }
}
