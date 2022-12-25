package leetcode.leetcode26;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2506 {

    public int similarPairs(String[] words) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int cur = getRes(word);
            map.putIfAbsent(cur, 0);
            result += map.get(cur);
            map.put(cur, map.get(cur) + 1);
        }
        return result;
    }

    private int getRes(String word) {
        boolean[] exist = new boolean[26];
        for (char c : word.toCharArray()) {
            exist[c - 'a'] = true;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (exist[i]) {
                result += 1 << i;
            }
        }

        return result;
    }


}
