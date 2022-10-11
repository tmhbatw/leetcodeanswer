package leetcode.leetcode25;

public class Leetcode2433 {

    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        int[] pre = new int[pref.length];
        res[0] = pref[0];
        pre[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = pre[i - 1] ^ pref[i];
            pre[i] = res[i] ^ pre[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int a1 = 5;
        int a2 = 0;
        System.out.println(a1 ^ a2);
    }


}
