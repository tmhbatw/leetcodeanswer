package leetcode.leetcode29;

public class Leetcode2843 {

    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String num = i + "";
            if (num.length() % 2 == 1) {
                continue;
            }
            int num1 = 0, num2 = 0;
            for (int j = 0; j < (num.length() / 2); j++) {
                num1 += num.charAt(j) - '0';
                num2 += num.charAt(num.length() - j - 1) - '0';
            }
            if (num1 == num2) {
                result++;
            }
        }
        return result;
    }

}
