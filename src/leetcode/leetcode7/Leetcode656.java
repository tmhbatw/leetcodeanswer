package leetcode.leetcode7;

import java.util.*;

public class Leetcode656 {

    class Point {
        int index;
        List<Integer> list;
        int sum;

        public Point(int index, List<Integer> list, int sum) {
            this.index = index;
            this.list = list;
            this.sum = sum;
        }
    }

    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        //保存最小的值
        int[] dp = new int[coins.length];
        dp[0] = coins[0];
        //保存路径
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for (int i = 1; i < coins.length; i++) {
            if (deque.isEmpty())
                return Collections.emptyList();

            if (coins[i] >= 0) {
                dp[i] = coins[i] + dp[deque.peekFirst()];
                List<Integer> l = new ArrayList<>(result.get(deque.peekFirst()));
                l.add((i + 1));
                result.add(l);
                while (!deque.isEmpty() && (dp[deque.peekLast()] > dp[i] ||
                        dp[deque.peekLast()] == dp[i] && compare(l, result.get(deque.peekLast()))))
                    deque.pollLast();
                deque.add(i);
            } else {
                result.add(new ArrayList<>());
            }


            if (i >= maxJump && deque.peekFirst() == i - maxJump)
                deque.pollFirst();
        }
        return result.get(result.size() - 1);
    }

    public boolean compare(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (l1.get(i) < l2.get(i))
                return true;
            else if (l1.get(i) > l2.get(i))
                return false;
        }
        return l1.size() > l2.size();
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
    }
}
