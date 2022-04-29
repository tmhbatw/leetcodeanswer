package leetcode.leetcode22;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2189 {
    Map<Integer,Integer> map=new HashMap<>();

    public int houseOfCards(int n) {
        return function(n,Integer.MAX_VALUE);
    }

    private int function(int n,int pre){
        if(n==0)
            return 1;

        int cur=n*1000+pre;
        if(map.containsKey(cur))
            return map.get(cur);

        int result = 0;
        for(int i=2;i<Math.min(n+1,pre);i+=3){
            result += function(n-i,i);
        }

        map.put(cur,result);
        return result;
    }


    public static void main(String[] args){
        int result = 500;
        Leetcode2189 c = new Leetcode2189();
        System.out.println(c.houseOfCards(result));


    }
}
