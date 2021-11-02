package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        while(count<costs.length&&coins>=costs[count])
            coins-=costs[count++];
        return count;
    }
}
