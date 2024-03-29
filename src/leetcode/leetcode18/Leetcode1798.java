package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int cur=0;
        for(int coin:coins){
            if(coin<=cur+1){
                cur+=coin;
            }else
                break;
        }
        return cur+1;
    }
}
