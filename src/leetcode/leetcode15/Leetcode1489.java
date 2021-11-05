package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1489 {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 并查集集合初始化
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p.add(i);
        }
        // 将所有边添加到列表当中
        List<int[]> nes = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            nes.add(new int[]{i, edges[i][0], edges[i][1], edges[i][2]});
        }

        int minTreeWeight = getRes(new ArrayList<>(p), nes, 0);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        List<int[]> temp = new ArrayList<>(nes);

        for (int[] cur: nes) {
            temp.remove(cur);
            if (minTreeWeight != getRes(new ArrayList<>(p), temp, 0)) {
                res.get(0).add(cur[0]);
            }
            temp.add(cur);

        }
        for (int[] cur : nes) {
            if (res.get(0).contains(cur[0]))
                continue;

            List<Integer> tp = new ArrayList(p);
            // 提前连上这条边的两个端点
            tp.set(cur[1], cur[2]);
            // 判断权重是否和之前相同
            if (minTreeWeight == getRes(tp, temp, cur[3])) {
                res.get(1).add(cur[0]);
            }
        }
        return res;
    }

    private int getRes(List<Integer> p, List<int[]> nes, int w) {
        // 对边从小到大进行排序
        Collections.sort(nes, (a, b) -> a[3] - b[3]);
        for (int[] cur : nes) {
            int a = getType(p, cur[1]), b = getType(p, cur[2]);
            if (a != b) {
                w += cur[3];
                p.set(a, b);
            }
        }
        return w;
    }

    private int getType(List<Integer> type, int cur) {
        if (type.get(cur) != cur) {
            type.set(cur, getType(type, type.get(cur)));
        }
        return type.get(cur);
    }
}
