package leetcode.leetcode23;

import java.util.*;

public class Leetcode2204 {

    //先找到环
    //然后就好做了
    int start = -1, end = -1;
    boolean flag = false;

    public int[] distanceToCycle(int n, int[][] edges) {
        int[] type = new int[n];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < type.length; i++) {
            type[i] = i;
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);

            if (start == -1) {
                int t1 = getType(type, edge[0]);
                int t2 = getType(type, edge[1]);
                if (t1 == t2) {
                    start = edge[0];
                    end = edge[1];
                }
                type[t2] = t1;
            }
        }

        Stack<Integer> s = new Stack<>();
        boolean[] reached = new boolean[n];
        dfs(start, reached, s, list);

        int[] result = new int[n];
        Queue<Integer> q = new LinkedList<>(s);
        int dis = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int next : list.get(cur)) {
                    if (!reached[next]) {
                        reached[next] = true;
                        q.add(next);
                        result[next] = dis;
                    }
                }
            }
            dis++;
        }

        return result;
    }

    private void dfs(int cur, boolean[] reached, Stack<Integer> s, List<List<Integer>> list) {
        if (flag)
            return;
        s.add(cur);
        reached[cur] = true;
        if (cur == end) {
            flag = true;
            return;
        }

        for (int next : list.get(cur)) {
            if (cur == start && next == end)
                continue;
            if (!reached[next]) {
                dfs(next, reached, s, list);
                if (flag)
                    return;
            }
        }
        reached[cur] = false;
        s.pop();
    }

    private int getType(int[] type, int cur) {
        if (type[cur] == cur)
            return cur;
        return getType(type, type[cur]);
    }

}
