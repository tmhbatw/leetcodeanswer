package leetcode.leetcode8;

import java.util.*;

public class Leetcode787 {

    class Flight{
        int next;
        int price;
        public Flight(int next,int price){
            this.next=next;
            this.price=price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] result=new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[src]=0;
        List<List<Flight>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] f:flights){
            list.get(f[0]).add(new Flight(f[1],f[2]));
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});
        while(!q.isEmpty()&&k>=0){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(Flight next:list.get(cur[0])){
                    if(next.price+cur[1]<result[next.next]){
                        result[next.next]=next.price+cur[1];
                        q.add(new int[]{next.next,result[next.next]});
                    }
                }
            }

            k--;

        }
        return result[dst]==Integer.MAX_VALUE?-1:result[dst];
    }
}
