package leetcode.leetcode12;

import java.util.Arrays;

public class Leetcode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int cur1=0;
        int min=Math.min(start,destination);
        int max=Math.max(start,destination);
        for(int i=min;i<max;i++)
            cur1+=distance[i];
        int sum= Arrays.stream(distance).sum();
        return Math.min(cur1,sum-cur1);
    }
}
