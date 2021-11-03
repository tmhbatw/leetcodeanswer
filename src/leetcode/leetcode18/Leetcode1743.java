package leetcode.leetcode18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] cur:adjacentPairs){
            map.putIfAbsent(cur[0],new ArrayList<>());
            map.putIfAbsent(cur[1],new ArrayList<>());
            map.get(cur[0]).add(cur[1]);
            map.get(cur[1]).add(cur[0]);
        }
        int[] res=new int[adjacentPairs.length+1];
        int pre=Integer.MAX_VALUE;
        int cur=0;
        for(int key:map.keySet()){
            if(map.get(key).size()==1){
                cur=key;
                break;
            }
        }
        for(int i=0;i<res.length;i++){
            res[i]=cur;
            List<Integer> next=map.get(cur);
            int temp=cur;
            if(i==res.length-1)
                break;
            if(next.get(0)==pre)
                cur=next.get(1);
            else
                cur=next.get(0);
            pre=temp;
        }
        return res;
    }
}
