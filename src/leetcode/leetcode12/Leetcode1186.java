package leetcode.leetcode12;

public class Leetcode1186 {

    public int maximumSum(int[] arr) {
        int[] pre=new int[]{-1000000,-1000000};
        int result = Integer.MIN_VALUE ;
        for (int j : arr) {
            pre[1] = Math.max(pre[1] + j, pre[0]);
            pre[0] = Math.max(pre[0] + j, j);
            result = Math.max(result, Math.max(pre[0], pre[1]));
        }
        return result;
    }

}
