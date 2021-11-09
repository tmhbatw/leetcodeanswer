package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode973 {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(o1,o2)->{
            int oo1=o1[0]*o1[0]+o1[1]*o1[1];
            int oo2=o2[0]*o2[0]+o2[1]*o2[1];
            return oo1-oo2;
        });

        int[][] result=new int[k][];
        if (result.length >= 0) System.arraycopy(points, 0, result, 0, result.length);
        return result;
    }

}
