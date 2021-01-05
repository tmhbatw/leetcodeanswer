package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Leetcode149 {
    /*Description
    * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
    * */

    //对每一个顶点做统计
    public int maxPoints(int[][] points) {
        if(points==null)
            return 0;
        if (points.length < 3)
            return points.length;
        int maxCount = 1;
        for (int i = 0; i < points.length - 1; i++) {
            maxCount = Math.max(recursion(points, i), maxCount);
        }
        return maxCount;
    }

    int x;
    Map<String, Integer> map = new HashMap<>();
    int count;
    int same;

    public int recursion(int[][] points, int i) {
        clear();
        for (int j = i + 1; j < points.length; j++)
            statistic(points, i, j);
        return Math.max(count,x)+ same;
    }

    private void clear() {
        map.clear();
        x = 1;
        count = 1;
        same = 0;
    }

    private void statistic(int[][] points, int i, int j) {
        int x1 = points[i][0], y1 = points[i][1];
        int x2 = points[j][0], y2 = points[j][1];

        if ((x1 == x2) && (y1 == y2))
            same++;
        else if (y1 == y2) {
            x ++;
        }
        else {
            String key = getKey(x1 - x2, y1 - y2);
            map.put(key, map.getOrDefault(key, 1) + 1);
            count = Math.max(map.get(key), count);
        }
    }

    private String getKey(int p, int q) {
        int gcd = getGcd(p, q);
        return p / gcd + " " + q / gcd;
    }

    private int getGcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return getGcd(q, r);
    }
}
