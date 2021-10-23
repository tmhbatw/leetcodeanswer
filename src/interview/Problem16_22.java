package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem16_22 {

    private HashMap<String, Character> map = new HashMap<>();
    private int left = 0, right = 0, bottom = 0, top = 0;   //记录边界位置
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final char[] dic = {'R', 'D', 'L', 'U'};
    private int dir = 0;
    public List<String> printKMoves(int K) {
        dfs(0, 0, K);
        List<String> res = new ArrayList<>();
        for (int i = top; i <= bottom; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = left; j <= right; j++) {
                String key = i + " " + j;
                char c = map.getOrDefault(key, '_');
                sb.append(c);
            }
            res.add(sb.toString());
        }
        return res;
    }
    private void dfs(int x, int y, int K) {
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
        String key = x + " " + y;
        char c = map.getOrDefault(key, '_');
        map.put(key, c == '_' ? 'X' : '_');
        if (K == 0) {
            map.put(key, dic[dir % 4]);
            return;
        }
        if (c == '_') {
            dir = (dir + 1) % 4;
        } else {
            dir = (dir - 1 + 4) % 4;
        }
        int newX = x + directions[dir % 4][0];
        int newY = y + directions[dir % 4][1];
        dfs(newX, newY, K - 1);
    }

}
