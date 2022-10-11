package leetcode.leetcode25;

public class Leetcode2432 {

    public int hardestWorker(int n, int[][] logs) {
        int result = 0;
        int cur = 0;

        int time = 0;
        for (int[] log : logs) {
            int curr = log[1] - time;
            if (curr > cur || curr == cur && log[0] < result) {
                result = log[0];
                cur = curr;
            }
            time = log[1];
        }

        return result;
    }


}
