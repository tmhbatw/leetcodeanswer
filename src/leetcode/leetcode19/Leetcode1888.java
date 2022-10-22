package leetcode.leetcode19;

public class Leetcode1888 {

    public int minFlips(String s) {
        int length = s.length();
        //偶数位置0、1的个数
        int even0 = 0;
        int even1 = 0;
        //奇数位置0、1的个数
        int odd0 = 0;
        int odd1 = 0;

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0')
                    even0++;
                else
                    even1++;
            } else {
                if (s.charAt(i) == '0')
                    odd0++;
                else
                    odd1++;
            }
        }

        int res = Math.min(even1 + odd0, even0 + odd1);
        if (length % 2 == 0) {
            return res;
        }

        for (int i = 0; i < length; i++) {

            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    even0--;
                    odd0++;
                } else {
                    even1--;
                    odd1++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    odd1--;
                    even1++;
                } else {
                    odd0--;
                    even0++;
                }
            }

            res = Math.min(res, Math.min(even1 + odd0, even0 + odd1));
        }

        return res;
    }

    private int getCount(String s, char cur) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != cur)
                count++;
            cur = cur == '0' ? '1' : '0';
        }
        return count;
    }


}
