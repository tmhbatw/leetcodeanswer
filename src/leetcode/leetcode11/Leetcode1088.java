package leetcode.leetcode11;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1088 {


    //要剪枝哦
    public int confusingNumberII(int n) {
        if (n <= 6)
            return 1;
        if (n <= 9)
            return 2;
        int[] next = new int[]{0, 1, 6, 8, 9};
        int[] reverse = new int[]{0, 1, 9, 8, 6};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        q.add(new int[]{6, 9});
        q.add(new int[]{8, 8});
        q.add(new int[]{9, 6});

        int result = 2;
        int base = 10;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur == null)
                    continue;
                for (int i = 0; i < 5; i++) {
                    int ii = cur[0] * 10 + next[i];
                    if (ii > n)
                        continue;

                    int jj = base * reverse[i] + cur[1];
                    if (ii != jj) {
                        result++;
                    }
                    if (ii <= n / 10)
                        q.add(new int[]{ii, jj});
                }
            }
            base *= 10;
        }
        return result;
    }


}
