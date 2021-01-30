package leetcode5;

public class Leetcode453 {
    /*Description
    * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
    * */


    public int minMoves(int[] nums) {
        int min=Integer.MIN_VALUE;
        for(int cur:nums)
            min=Math.min(cur,min);
        int result=0;
        for(int cur:nums)
            result+=cur-min;
        return result;
    }

}
