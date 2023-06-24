package leetcode.leetcode27;

public class Leetcode2609 {

    public int findTheLongestBalancedSubstring(String s) {
        int preZeroTime = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                preZeroTime++;
            } else {
                int start = i;
                while (i < s.length() - 1 && s.charAt(i + 1) == '1') {
                    i++;
                }
                result = Math.max(result, Math.min(i - start + 1, preZeroTime));
                preZeroTime = 0;
            }
        }
        return result * 2;
    }

}
