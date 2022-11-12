package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1850 {


    public int getMinSwaps(String num, int k) {
        char[] c = num.toCharArray();
        while (k-- > 0) {
            next(c);
        }

        char[] n = num.toCharArray();
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] != c[i]) {
                for (int j = i + 1; j < n.length; j++) {
                    if (n[i] == c[j]) {
                        result += j - i;
                        while (j > i) {
                            c[j] = c[j - 1];
                            j--;
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }

    private void next(char[] c) {
        char max = c[c.length - 1];
        for (int j = c.length - 2; j >= 0; j--) {
            //说明可以进行next操作
            if (c[j] < max) {
                int l = j + 1, r = c.length - 1;
                while (l < r) {
                    int mid = (l + r + 1) / 2;
                    if (c[mid] > c[j]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                char temp = c[j];
                c[j] = c[l];
                c[l] = temp;
                Arrays.sort(c, j + 1, c.length);
                return;
            } else {
                max = (char) Math.max(max, c[j]);
            }
        }
    }

    public static void main(String[] args) {
        String test = "5489355142";
        char[] c = test.toCharArray();
        System.out.println(new String(c));
        new Leetcode1850().next(c);
        System.out.println(new String(c));
        new Leetcode1850().next(c);
        System.out.println(new String(c));
        new Leetcode1850().next(c);
        System.out.println(new String(c));
        new Leetcode1850().next(c);
        System.out.println(new String(c));
    }


}
