package leetcode.leetcode13;

public class Leetcode1216 {

    public boolean isValidPalindrome(String s, int k) {
        int length = s.length();
        int[][] res = new int[length][length];
        char[] c = s.toCharArray();
        for (int l = 1; l < length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l;
                if (c[i] == c[j])
                    res[i][j] = res[i + 1][j - 1];
                else
                    res[i][j] = Math.min(res[i + 1][j], res[i][j - 1]) + 1;
            }
        }
        return res[0][length - 1] <= k;
    }


}
