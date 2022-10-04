package leetcode.leetcode24;

public class Leetcode2361 {

    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[][] result = new long[regular.length + 1][2];
        result[0][1] = expressCost;
        long[] res = new long[regular.length];

        for (int i = 0; i < regular.length; i++) {
            result[i + 1][0] = Math.min(Math.min(result[i][0] + regular[i], result[i][0] + expressCost + express[i]),
                    Math.min(result[i][1] + regular[i], result[i][1] + express[i]));
            result[i + 1][1] = Math.min(Math.min(result[i][0] + regular[i] + expressCost, result[i][0] + express[i] + expressCost),
                    Math.min(result[i][1] + regular[i] + expressCost, result[i][1] + express[i]));

            res[i] = Math.min(result[i + 1][0], result[i + 1][1]);
        }

        return res;
    }


}
