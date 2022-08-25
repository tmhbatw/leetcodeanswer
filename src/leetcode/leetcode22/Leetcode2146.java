package leetcode.leetcode22;

import java.util.*;

public class Leetcode2146 {

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<int[]> l=new ArrayList<>();
        int[][] n=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        if(grid[start[0]][start[1]]<=pricing[1]&&grid[start[0]][start[1]]>=pricing[0]) {
            l.add(new int[]{0, 0, start[0], start[1]});
        }
        grid[start[0]][start[1]]=0;
        int dis=1;
        while(!q.isEmpty()){
            int size=q.size();
            dis++;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] next:n){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii<grid.length&&ii>=0&&jj>=0&&jj<grid[0].length&&grid[ii][jj]>0){
                        if(grid[ii][jj]<=pricing[1]&&grid[ii][jj]>=pricing[0]) {
                            l.add(new int[]{dis, grid[ii][jj], ii, jj});
                        }
                        grid[ii][jj]=0;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }
        l.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o1[3] - o2[3];
                    }
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<Math.min(k,l.size());i++){
            List<Integer> res=new ArrayList<>();
            res.add(l.get(i)[2]);
            res.add(l.get(i)[3]);
            result.add(res);
        }
        return result;
    }

}
