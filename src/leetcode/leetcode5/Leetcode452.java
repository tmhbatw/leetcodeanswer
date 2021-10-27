package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode452 {

    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0)
            return 0;

        Arrays.sort(points,(o1,o2)->{
            return (o1[1]<o2[1]?-1:1);
        });

        int count=1;
        int pre=points[0][1];

        for(int i=1;i<points.length;i++){
            if(pre>=points[i][0])
                continue;
            count++;
            pre=points[i][1];
        }

        return count;
    }
}
