package leetcode.leetcode13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1273 {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] val=value;
        int[] time=new int[nodes];
        Arrays.fill(time,1);

        int[] degree=new int[nodes];
        for(int num:parent){
            if(num>=0)
                degree[num]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<nodes;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==0)
                break;
            if(val[cur]!=0){
                val[parent[cur]]+=val[cur];
                time[parent[cur]]+=time[cur];
            }
            degree[parent[cur]]--;
            if(degree[parent[cur]]==0)
                q.add(parent[cur]);
        }
        //System.out.println(Arrays.toString(time));
        //System.out.println(Arrays.toString(val));
        return val[0]==0?0:time[0];
    }
}
