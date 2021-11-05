package leetcode.leetcode19;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1884 {

    Map<Integer,Integer> map=new HashMap<>();
    public int twoEggDrop(int n) {
        return eggDrop(n,2);
    }

    private int eggDrop(int n,int k){
        if(n<=0)
            return 0;
        if(k==1)
            return n;
        if(map.containsKey(n))
            return map.get(n);
        int cur=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            int curr=1+Math.max(eggDrop(i-1,1),eggDrop(n-i-1,2));
            cur=Math.min(cur,curr);
        }
        map.put(n,cur);
        return map.get(n);
    }
}
