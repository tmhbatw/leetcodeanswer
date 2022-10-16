package leetcode.leetcode25;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2438 {

    public int[] productQueries(int n, int[][] queries) {
        String nn = Integer.toBinaryString(n);
        List<Integer> list = new ArrayList<>();

        int base = 1;
        for (int j = nn.length() - 1; j >= 0; j--) {
            if (nn.charAt(j) == '1')
                list.add(base);
            base *= 2;
        }
        int[] result = new int[queries.length];
        int mod = 1000000007;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            long cur = 1;
            for (int j = query[0]; j <= query[1]; j++) {
                cur *= list.get(j);
                cur %= mod;
            }
            result[i] = (int) cur;
        }
        return result;
    }


}
