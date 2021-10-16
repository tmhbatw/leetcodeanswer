package leetcode.leetcode18;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=lowLimit;i<=highLimit;i++){
            int cur=0;
            int num=i;
            while (num > 0) {
                cur+=num%10;
                num/=10;
            }
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int result=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            result=Math.max(result,entry.getValue());
        return result;
    }
}
