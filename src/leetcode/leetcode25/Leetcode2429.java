package leetcode.leetcode25;

public class Leetcode2429 {

    public int minimizeXor(int num1, int num2) {
        String n1 = Integer.toBinaryString(num1);
        char[] c1 = n1.toCharArray();
        int l1 = c1.length;
        int l2 = Integer.toBinaryString(num2).length();
        if (l1 < l2) {
            char[] c = new char[l2];
            for (int i = 0; i < l2 - l1; i++) {
                c[i] = '0';
            }
            for (int i = l2 - l1; i < l2; i++)
                c[i] = c1[i - l2 + l1];
            c1 = c;
        }

        int bit1 = Integer.bitCount(num1);
        int bit2 = Integer.bitCount(num2);
        if (bit1 > bit2) {
            int count = bit1 - bit2;
            for (int j = c1.length - 1; j >= 0; j--) {
                if (c1[j] == '1') {
                    c1[j] = '0';
                    count--;
                    if (count == 0)
                        break;
                }
            }
            return Integer.parseInt(new String(c1), 2);
        }
        if (bit1 < bit2) {
            int count = bit2 - bit1;
            for (int j = c1.length - 1; j >= 0; j--) {
                if (c1[j] == '0') {
                    count--;
                    c1[j] = '1';
                    if (count == 0)
                        break;
                }
            }
            return Integer.parseInt(new String(c1), 2);
        }
        return num1;
    }
}
