package leetcode.leetcode12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode1197 {

    int[][] nextPos=new int[][]{{1,2},{2,1},{-1,-2},{-2,-1},
            {1,-2},{2,-1},{-1,2},{-2,1}};
    public int minKnightMoves(int x, int y) {
        if(x==0&&y==0)
            return 0;
        int distance=1;
        Set<Integer> set=new HashSet<>();
        set.add(0);
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] n:nextPos){
                    int i=n[0]+cur[0];
                    int j=n[1]+cur[1];
                    if(i==x&&y==j)
                        return distance;
                    if(!set.contains(i*1000+j)) {
                        q.add(new int[]{i,j});
                        set.add(i*1000+j);
                    }
                }
            }
            distance++;
        }
        return -1;
    }


}
