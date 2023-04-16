package leetcode.leetcode26;

import java.util.PriorityQueue;

public class Leetcode2558 {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            q.add(gift);
        }
        while (k-- > 0) {
            q.add((int) Math.sqrt(q.poll()));
        }
        long result = 0;
        for (int cur : q) {
            result += cur;
        }
        return result;
    }

}
