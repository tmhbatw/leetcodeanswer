package leetcode.leetcode11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum= Arrays.stream(stones).sum();
        boolean[] reached=new boolean[sum/2];
        reached[0]=true;
        for(int stone:stones){
            for(int j=reached.length-1;j>=stone;j--){
                if(reached[j-stone])
                    reached[j]=true;
            }
        }
        for(int j=reached.length-1;j>=0;j--){
            if(reached[j])
                return sum-j;
        }
        return -1;
    }

    private int getStone(int cur1,int cur2){
        return Math.max(cur1,cur2)-Math.min(cur1,cur2);
    }
}
