package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode828 {

    public int uniqueLetterString(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(-1);
            list.add(cur);
        }

        for (int i = 0; i < s.length(); i++) {
            list.get(s.charAt(i) - 'A').add(i);
        }

        int result = 0;
        for (List<Integer> cur : list) {
            cur.add(s.length());
            for (int i = 1; i < cur.size() - 1; i++) {
                result += (cur.get(i) - cur.get(i - 1)) * (cur.get(i + 1) - cur.get(i));
            }
        }

        return result;
    }


}
