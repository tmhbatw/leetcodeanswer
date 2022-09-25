package leetcode.leetcode15;

import java.util.*;

public class Leetcode1488 {

    public int[] avoidFlood(int[] rains) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        Map<Integer,Boolean> reached=new HashMap<>();
        for(int i=0;i<rains.length;i++){
            map.putIfAbsent(rains[i],new ArrayList<>());
            map.get(rains[i]).add(i);
            reached.put(rains[i],false);
        }
        //System.out.println(map);

        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[] result=new int[rains.length];
        for(int i=0;i<rains.length;i++){
            if(rains[i]>0){
                result[i]=-1;
                if(reached.get(rains[i]))
                    return new int[0];
                reached.put(rains[i],true);
                List<Integer> list=map.get(rains[i]);
                int l=0,r=list.size()-1;
                while(l<r){
                    int mid=(l+r+1)/2;
                    if(list.get(mid)<=i)
                        l=mid;
                    else{
                        r=mid-1;
                    }
                }
                if(l<list.size()-1)
                    q.add(new int[]{list.get(l+1),rains[i]});
            }else{
                if(q.isEmpty()){
                    result[i]=1;
                }else{
                    int[] cur=q.poll();
                    reached.put(cur[1],false);
                    result[i]=cur[1];
                }
            }
            // System.out.println(Arrays.toString(result));
        }

        return result;
    }

}
