package leetcode.leetcode27;

public class Leetcode2696 {

    public int minLength(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("AB", i) || s.startsWith("CD", i)) {
                return minLength(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s.length();
    }

}
