package leetcode.leetcode26;

public class Leetcode2544 {

    public int alternateDigitSum(int n) {
        int result = 0;
        boolean positive = (n + "").length() % 2 != 0;
        while (n > 0) {
            result += positive ? n % 10 : -(n % 10);
            positive = !positive;
            n /= 10;
        }
        return result;
    }

}
