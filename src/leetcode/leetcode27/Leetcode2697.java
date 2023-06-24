package leetcode.leetcode27;

public class Leetcode2697 {

    public String makeSmallestPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (c[i] != c[s.length() - i - 1]) {
                c[i] = c[s.length() - 1 - i] = (char) Math.min(c[i], c[s.length() - 1 - i]);
            }
        }
        return new String(c);
    }

}
