package leetcode.leetcode26;

import java.util.Arrays;

public class Leetcode2517 {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = 1000000000;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (match(price, k, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private boolean match(int[] price, int k, int mid) {
        int count = 1;
        int pre = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - pre >= mid) {
                pre = price[i];
                count++;
            }
        }

        return count >= k;
    }
}
