package leetcode3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode253 {
    /*Description
    * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i]
    * = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
    * */

    public int minMeetingRooms(int[][] intervals) {
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
    }
}
