package leetcode1;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode45 {
    /*Description
    * 给定一个非负整数数组，你最初位于数组的第一个位置。
    * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
    * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    * */

    public int jump(int[] nums) {
        if(nums==null||nums.length<=1)
            return 0;
        int length=nums.length;
        int time=0;
        int first=0,last=1;
        while(first<last){
            time++;
            int index=last-1;
            for(int i=first;i<last;i++){
                index=Math.max(index,i+nums[i]+1);
            }
            if(index>=length)
                return time;
            first=last;
            last=index;
        }
        return -1;
    }
}
