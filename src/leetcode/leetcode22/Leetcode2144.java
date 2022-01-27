package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2144 {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int result=0;
        for(int j=cost.length-1;j>=0;j--){
            if((cost.length-j)%3==0)
                continue;
            result+=cost[j];
        }

        return result;
    }
}
