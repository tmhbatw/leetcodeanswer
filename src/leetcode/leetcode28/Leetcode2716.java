package leetcode.leetcode28;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2716 {

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

}
