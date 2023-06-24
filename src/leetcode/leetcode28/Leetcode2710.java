package leetcode.leetcode28;

public class Leetcode2710 {

    public String removeTrailingZeros(String num) {
        if (num.charAt(num.length() - 1) == '0') {
            return removeTrailingZeros(num.substring(0, num.length() - 1));
        }
        return num;
    }
}
