package leetcode.leetcode25;

import java.util.PriorityQueue;

public class Leetcode2462 {

    static class Worker {
        int cost;
        boolean isForward;
        int index;

        public Worker(int cost, boolean isForward, int index) {
            this.cost = cost;
            this.isForward = isForward;
            this.index = index;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Worker> p = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost == o2.cost)
                return o1.index - o2.index;
            return o1.cost - o2.cost;
        });

        int i = candidates - 1;
        int j = costs.length - candidates;
        if (candidates * 2 >= costs.length) {
            for (int cost : costs) {
                p.add(new Worker(cost, true, 0));
            }
        } else {
            for (int ii = 0; ii < candidates; ii++)
                p.add(new Worker(costs[ii], true, ii));
            for (int jj = costs.length - 1; jj >= costs.length - candidates; jj--)
                p.add(new Worker(costs[jj], false, jj));
        }

        long result = 0;
        while (k-- > 0) {
            Worker cur = p.poll();
            if (cur == null)
                continue;
            result += cur.cost;
            if (i >= j - 1)
                continue;
            if (cur.isForward) {
                p.add(new Worker(costs[i + 1], true, ++i));
            } else {
                p.add(new Worker(costs[j - 1], false, --j));
            }
            System.out.println(cur.cost + " " + cur.isForward);
        }

        return result;
    }


}
