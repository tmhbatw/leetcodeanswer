package leetcode.leetcode18;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1786 {

    public int maximumBeauty(int[] flowers) {
        int[] sum=new int[flowers.length+1];
        for(int i=0;i<flowers.length;i++)
            sum[i+1]=sum[i]+Math.max(flowers[i],0);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<flowers.length;i++)
            map.put(flowers[i],i);
        int result=Integer.MIN_VALUE;
        for(int i=0;i<flowers.length;i++){
            int j=map.get(flowers[i]);
            if(j>i) {
                result = Math.max(result,sum[j]-sum[i+1]);
            }
        }
        return result;
    }
}
