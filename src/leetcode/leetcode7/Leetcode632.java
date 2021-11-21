package leetcode.leetcode7;

import java.util.List;
import java.util.PriorityQueue;

public class Leetcode632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        int start=0;
        int curMax=0;
        int max=Integer.MAX_VALUE;

        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o1[0]-o2[0];
        });

        for(int i=0;i<nums.size();i++) {
            q.add(new int[]{nums.get(i).get(0), i, 0});
            curMax=Math.max(curMax,nums.get(i).get(0));
        }

        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(curMax-cur[0]<max){
                max=curMax-cur[0];
                start=cur[0];
            }

            if(cur[2]==nums.get(cur[1]).size()-1)
                break;
            cur[2]++;
            cur[0]=nums.get(cur[1]).get(cur[2]);
            curMax=Math.max(cur[0],curMax);
            q.add(cur);
        }

        return new int[]{start,start+max};
    }
}
