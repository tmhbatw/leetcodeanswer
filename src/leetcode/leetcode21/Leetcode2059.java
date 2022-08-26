package leetcode.leetcode21;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode2059 {


    public int minimumOperations(int[] nums, int start, int goal) {
        if(start==goal)
            return 0;
        int dis=0;
        boolean[] reached=new boolean[1001];
        reached[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            dis++;
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                for(int num:nums){
                    if(f(cur+num,reached,goal,q)||
                        f(cur-num,reached,goal,q)||
                        f(cur^num,reached,goal,q))
                        return dis;
                }
            }
        }
        return -1;
    }

    private boolean f(int cur,boolean[] reached,int goal,Queue<Integer> q){
        if(cur==goal)
            return true;
        if(cur<=1000&&cur>=0&&!reached[cur]){
            reached[cur]=true;
            q.add(cur);
        }
        return false;
    }


}
