package leetcode.leetcode12;

import javax.sound.sampled.Line;
import java.util.*;

public class Leetcode1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result=new int[n];
        Arrays.fill(result,-1);
        result[0]= 0;
        boolean[] reachedRed=new boolean[n];
        boolean[] reachedBlue = new boolean[n];
        List<List<Integer>> red=new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();

        for(int i=0;i<n;i++){
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for(int[] edge:redEdges){
            red.get(edge[0]).add(edge[1]);
        }
        for(int[] edge:blueEdges){
            blue.get(edge[0]).add(edge[1]);
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        int dis=0;

        while(!q.isEmpty()){
            dis++;
            int size=q.size();

            while(size-->0){
                int[] cur=q.poll();
                if(cur[1]==0){//下一个是blue
                    for(int next:blue.get(cur[0])){
                        if(!reachedBlue[next]){
                            reachedBlue[next]=true;
                            if(result[next]==-1){
                                result[next]=dis;
                            }
                            q.add(new int[]{next,1});
                        }
                    }
                }else { //下一个是red
                    for(int next:red.get(cur[0])){
                        if(!reachedRed[next]){
                            reachedRed[next]=true;
                            if(result[next]==-1){
                                result[next]=dis;
                            }
                            q.add(new int[]{next,0});
                        }
                    }
                }
            }
        }

        return result;
    }
}
