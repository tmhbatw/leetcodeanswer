package leetcode.leetcode26;

public class Leetcode2520 {

    public int countDigits(int num) {
        int cur = num;
        int result = 0;
        while (cur > 0) {
            if (num % (cur % 10) == 0) {
                result++;
            }
            cur /= 10;
        }
        return result;
    }

}
