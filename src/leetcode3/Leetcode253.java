package leetcode3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode253 {
    /*Description
    * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i]
    * = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
    * */

    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;
        int length= intervals.length;
        int[] start=new int[length];
        int[] end=new int[length];
        for(int i=0;i<length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));
        int sIndex=0,eIndex=0;
        int result=0;
        int max=0;
        while(sIndex<length&&eIndex<length){
            if(end[eIndex]<=start[sIndex]){
                eIndex++;
                result--;
            }else{
                result++;
                max=Math.max(result,max);
                sIndex++;
            }
        }
        return max;
    }
    //TreeMap算法，时间复杂度很垃圾
/*    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int[] cur:intervals){
            map.put(cur[0],map.getOrDefault(cur[0],0)+1);
            map.put(cur[1],map.getOrDefault(cur[1],0)-1);
        }
        int result=0;
        int max=0;
        for(Map.Entry entry:map.entrySet()){
            int val=(int)entry.getValue();
            result+=val;
            max=Math.max(max,result);
        }
        return max;
    }*/
}
