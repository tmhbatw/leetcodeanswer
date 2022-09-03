package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1040 {


    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int min = getMin(stones);
        int max=getMax(stones);
        return new int[]{min,max};
    }

    private int getMax(int[] stones) {
        int length=stones.length;
        int space = stones[length-1]-stones[0]-length+1;
        int lastSpace = Math.min(stones[1]-stones[0]-1,stones[length-1]-stones[length-2]-1);
        return space-lastSpace;
    }

    private int getMin(int[] stones) {
        int length = stones.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            int last = stones[i] + length - 1;
            if (last > stones[length - 1])
                break;
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
            if(res==1&&stones[l]<last)
                res++;
            min=Math.min(min,res);
        }
        return min;
    }


}
