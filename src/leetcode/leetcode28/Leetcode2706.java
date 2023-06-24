package leetcode.leetcode28;

import java.util.Arrays;

public class Leetcode2706 {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int min = prices[0] + prices[1];
        return min <= money ? money - min : money;
    }

}
