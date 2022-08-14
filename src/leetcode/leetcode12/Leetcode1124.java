package leetcode.leetcode12;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import java.util.TreeMap;

public class Leetcode1124 {

    public int longestWPI(int[] hours) {
        int result = 0;
        int cur = 0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,-1);

        for(int i=0;i<hours.length;i++){
            if(hours[i]>8)
                cur++;
            else
                cur--;

            if(map.lowerKey(cur)!=null){
                int lowerKey=map.lowerKey(cur);
                result=Math.max(result,i-map.get(lowerKey));
            }else {
                if(!map.containsKey(cur))
                    map.put(cur,i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("hello world");
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);
        System.out.println(map.lowerKey(0));
    }
}
