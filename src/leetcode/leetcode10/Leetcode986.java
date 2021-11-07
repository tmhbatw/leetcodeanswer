package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result=new ArrayList<>();
        int index=0;
        for (int[] ints : secondList) {
            while (index < firstList.length && firstList[index][1] < ints[0])
                index++;
            if (index == firstList.length)
                break;

            while (index<firstList.length&&firstList[index][0] <= ints[1]) {
                result.add(new int[]{Math.max(firstList[index][0], ints[0]),
                        Math.min(firstList[index][1], ints[1])});
                index++;
            }
            index=Math.max(index-1,0);
        }
        int[][] res=new int[result.size()][2];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
    }
}
