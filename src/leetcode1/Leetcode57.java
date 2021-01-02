package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {
    /*Description
    * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    * */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null||intervals.length==0)
            return new int[][]{{newInterval[0],newInterval[1]}};
        List<int[]> res=new ArrayList<>();
        int length=intervals.length;
        int index=0;
        for(;index<length;index++){
            if(newInterval[0]>intervals[index][1])
                res.add(intervals[index]);
            else{
                while(index<length&&intervals[index][0]<=newInterval[1]){
                    newInterval[0]=Math.min(newInterval[0],intervals[index][0]);
                    newInterval[1]=Math.max(newInterval[1],intervals[index][1]);
                    index++;
                }
                res.add(newInterval);
                break;
            }
        }
        if(intervals[length-1][1]<newInterval[0])
            res.add(newInterval);
        for(;index<length;index++)
            res.add(intervals[index]);
        int[][] result=new int[res.size()][2];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
    }
}
