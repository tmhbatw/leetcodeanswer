package leetcode.leetcode14;

import java.util.*;

public class Leetcode1387 {

    Map<Integer,Integer> m=new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        List<int[]> list=new ArrayList<>();
        for(int i=lo;i<=hi;i++)
            list.add(new int[]{i,getRes(i)});
        Collections.sort(list,(o1,o2)->{
            if(o1[1]==o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        return list.get(k-1)[0];
    }

    private int getRes(int cur){
        if(cur==1)
            return 0;
        if(m.containsKey(cur))
            return m.get(cur);
        int next=cur/2;
        if(cur%2==1)
            next=3*cur+1;
        m.put(cur,getRes(next)+1);
        return m.get(cur);
    }
}
