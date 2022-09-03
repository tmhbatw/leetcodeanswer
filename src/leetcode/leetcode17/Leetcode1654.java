package leetcode.leetcode17;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[][] reached=new boolean[6001][2];
        reached[0][0]=reached[0][1]=true;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int dis=0;
        if(x==0)
            return dis;
        Set<Integer> set=new HashSet<>();
        for(int num:forbidden)
            set.add(num);

        while(!q.isEmpty()){
            int size=q.size();
            dis++;

            while(size-->0) {
                int[] cur = q.poll();
                if (cur[1] == 0) {//往前走

                    int add = cur[0] + a;
                    if (add == x)
                        return dis;
                    if (add <= 6001 && !reached[add][0] &&!set.contains(add)) {
                        reached[add][0] = true;
                        q.add(new int[]{add, 0});
                    }
                    if (add <= 6001 && !reached[add][1]&&!set.contains(add)) {
                        reached[add][1] = true;
                        q.add(new int[]{add, 1});
                    }


                } else {//往后退
                    int del=cur[0]-b;
                    if(del==x)
                        return dis;
                    if(del>=0&&!reached[del][0]&&!set.contains(del)) {
                        reached[del][0]=true;
                        q.add(new int[]{del,0});
                    }
                }
            }
        }

        return -1;
    }

}
