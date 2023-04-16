package leetcode.leetcode26;

public class Leetcode2566 {

    public int minMaxDifference(int num) {
        int[] res = getRes(num);
        return res[1] - res[0];
    }

    private int[] getRes(int num) {
        int[] res = new int[]{num, num};
        String s = (num + "");
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int max = getReplaceVal(s, s.charAt(i), '9');
            res[1] = Math.max(max, res[1]);
            int min = getReplaceVal(s, s.charAt(i), '0');
            res[0] = Math.min(min, res[0]);
        }
        return res;
    }

    private int getReplaceVal(String cur, char replace, char val) {
        char[] c = cur.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == replace) {
                c[i] = val;
            }
        }
        return Integer.parseInt(new String(c));
    }
}
