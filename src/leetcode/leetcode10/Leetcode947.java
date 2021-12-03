package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode947 {


    //每一个石头和自己同行同列的石头是一组石头
    public int removeStones(int[][] stones) {
        Map<Integer,Integer> type=new HashMap<>();
        Map<Integer,Integer> row=new HashMap<>();
        Map<Integer,Integer> col=new HashMap<>();
        int count=0;
        for(int[] stone:stones){
            int t=getType(stone[0],stone[1]);
            count++;
            type.putIfAbsent(t,t);

            if(row.containsKey(stone[0])){
                int t1=getType(type,t);
                int t2=getType(type,getType(stone[0],row.get(stone[0])));

                if(t1!=t2){
                    count--;
                    type.put(t1,t2);
                }
            }
            row.put(stone[0],stone[1]);

            if(col.containsKey(stone[1])){
                int t1=getType(type,t);
                int t2=getType(type,getType(col.get(stone[1]),stone[1]));

                if(t1!=t2){
                    count--;
                    type.put(t1,t2);
                }
            }
            col.put(stone[1],stone[0]);

        }
        return stones.length-count;
    }

    private int getType(int row,int col){
        return row*1001+col;
    }

    private int getType(Map<Integer,Integer> map, int cur){
        if(map.get(cur)==cur)
            return cur;
        return getType(map,map.get(cur));
    }
}
