package leetcode.leetcode26;

public class Leetcode2595 {

    public int[] evenOddBit(int n) {
        int[] result = new int[2];
        String num = Integer.toBinaryString(n);
        for (int i = 0; i < num.length(); i++) {
            result[(num.length() - 1 - i) % 2] += num.charAt(i) - '0';
        }
        return result;
    }

}
