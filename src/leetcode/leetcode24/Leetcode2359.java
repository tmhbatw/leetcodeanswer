package leetcode.leetcode24;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        boolean[] r1=new boolean[n],r2=new boolean[n];
        int[] d1=new int[n];
        int[] d2=new int[n];
        getDis(node1,edges,r1,d1);
        getDis(node2,edges,r2,d2);

        int res=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<n;i++){
            if(r1[i]&&r2[i]){
                int max = Math.max(d1[i],d2[i]);
                if(max<res) {
                    res = max;
                    index = i;
                }
            }
        }
        return index;
    }


    private void getDis(int cur,int[]edges,boolean[] r,int[] dis){
        r[cur]=true;
        int d=0;
        while(true){
            d++;
            cur = edges[cur];
            if(cur==-1||r[cur])
                break;
            dis[cur]+=d;
            r[cur]=true;
        }
    }
}
