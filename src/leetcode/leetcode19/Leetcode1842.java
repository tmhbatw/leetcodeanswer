package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1842 {

    public String nextPalindrome(String num) {
        boolean odd = (num.length() % 2 == 1);
        String realNum = num.substring(0, (num.length() + 1) / 2);
        char[] c = realNum.toCharArray();

        char max = '0';
        if (!odd) {
            for (int j = c.length - 1; j >= 0; j--) {
                if (c[j] < max) {
                    for (int k = c.length - 1; k >= j; k--) {
                        if (c[k] > c[j]) {
                            char temp = c[k];
                            c[k] = c[j];
                            c[j] = temp;
                            break;
                        }
                    }
                    Arrays.sort(c, j + 1, c.length);
                    String result = new String(c);
                    result += reverse(result);
                    return result;
                }
                max = (char) Math.max(c[j], max);
            }
        } else {
            for (int j = c.length - 2; j >= 0; j--) {
                if (c[j] < max) {
                    for (int k = c.length - 2; k >= j; k--) {
                        if (c[k] > c[j]) {
                            char temp = c[k];
                            c[k] = c[j];
                            c[j] = temp;
                            break;
                        }
                    }
                    Arrays.sort(c, j + 1, c.length - 1);
                    String result = new String(c);
                    result += reverse(result.substring(0, result.length() - 1));
                    return result;
                }
                max = (char) Math.max(c[j], max);
            }
        }

        return "";
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1};
        Arrays.sort(num, 1, 3);
        System.out.println(Arrays.toString(num));
    }


}
