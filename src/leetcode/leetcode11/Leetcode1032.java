package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1032 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] num=new int[]{a,b,c};
        return numMovesStonesII(num);
    }

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int min = getMin(stones);
        int max=getMax(stones);
        return new int[]{min,max};
    }

    private int getMax(int[] stones) {
        int length=stones.length;
        int space = stones[length-1]-stones[0]-length+1;
        return space;
    }

    private int getMin(int[] stones) {
        int length = stones.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            int last = stones[i] + length - 1;
            int l = i, r = length - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (stones[mid] <= last)
                    l = mid;
                else {
                    r = mid - 1;
                }
            }
            int cur = l-i+1;
            int res = length-cur;
            min=Math.min(min,res);
        }
        return min;
    }

}
