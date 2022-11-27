package leetcode.leetcode25;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2477 {

    long result = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }

        getRes(0, 0, list, seats);
        return result;
    }

    private long getRes(int cur, int father, List<List<Integer>> list, int seats) {
        long curPeople = 1;
        for (int next : list.get(cur)) {
            if (next == father)
                continue;
            curPeople += getRes(next, cur, list, seats);
        }
        if (cur != 0)
            result += (curPeople - 1) / seats + 1;
        return curPeople;
    }

}
