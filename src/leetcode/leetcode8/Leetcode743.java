package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode743 {

    class Node{
        int index;
        int val;
        public Node(int index,int val){
            this.index=index;
            this.val=val;
        }
        public String toString(){
            return this.index+" "+this.val;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k]=0;

        int point=n;
        List<List<Node>> list=new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int[] time:times){
            list.get(time[0]).add(new Node(time[1],time[2]));
        }

        PriorityQueue<Node> p=new PriorityQueue<>((o1,o2)->{
            return o1.val-o2.val;
        });
        p.add(new Node(k,0));
        while(!p.isEmpty()){
            Node cur=p.poll();
            if(cur.val>res[cur.index])
                continue;
            point--;
            if(point==0)
                return cur.val;
            for(Node next:list.get(cur.index)){
                if(next.val+cur.val<res[next.index]){
                    p.add(new Node(next.index,next.val+cur.val));
                    res[next.index]=next.val+cur.val;
                }
            }

        }
        return -1;
    }
}
