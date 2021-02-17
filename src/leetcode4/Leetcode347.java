package leetcode4;

import java.util.*;

public class Leetcode347 {
    /*Description
    * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    * */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        PriorityQueue<int[]> p=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o2[1]-o1[1];
            }
        });
        for(Map.Entry entry:map.entrySet()){
            p.add(new int[]{(int)entry.getKey(),(int)entry.getValue()});
        }
        List<Integer> list=new ArrayList<>();
        while(k-->0&&!p.isEmpty())
            list.add(p.poll()[0]);
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i);
        return result;
    }
}
