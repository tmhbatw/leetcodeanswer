package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1029 {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(o1,o2)->{
            return (o1[0]-o1[1])-(o2[0]-o2[1]);
        });
        int result=0;
        for(int i=0;i<costs.length/2;i++)
            result+=costs[i][0]+costs[i+costs.length/2][1];
        return result;
    }
}
