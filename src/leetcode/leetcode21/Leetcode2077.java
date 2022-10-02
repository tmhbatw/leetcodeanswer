package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2077 {

    public int numberOfPaths(int n, int[][] corridors) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        boolean[][] exist=new boolean[n+1][n+1];
        for(int[] edge:corridors){
            exist[edge[0]][edge[1]]=true;
            exist[edge[1]][edge[0]]=true;
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        int result=0;
        for(List<Integer> l:list){
            for(int i=0;i<l.size();i++){
                for(int j=i+1;j<l.size();j++){
                    if(exist[l.get(i)][l.get(j)]||exist[l.get(j)][l.get(i)])
                        result++;
                }
            }
        }

        return result/3;
    }
}
