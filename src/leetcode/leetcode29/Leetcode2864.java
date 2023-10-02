package leetcode.leetcode29;

public class Leetcode2864 {

    public String maximumOddBinaryNumber(String s) {
        int num1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                num1++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num1 - 1; i++) {
            result.append("1");
        }
        for (int i = 0; i < s.length() - num1; i++) {
            result.append("0");
        }
        result.append("1");
        return result.toString();
    }
}
