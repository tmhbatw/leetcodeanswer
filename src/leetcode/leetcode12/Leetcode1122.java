package leetcode.leetcode12;

import java.util.*;

public class Leetcode1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        int index=0;
        for(int i=0;i<arr2.length;i++)
            map.put(arr2[i],index++);

        List<Integer> list=new ArrayList<>();
        for(int cur:arr1)
            list.add(cur);

        list.sort((o1,o2)->{
            int o1Val=map.getOrDefault(o1,Integer.MAX_VALUE);
            int o2Val=map.getOrDefault(o2,Integer.MAX_VALUE);
            if(o1Val==o2Val)
                return o1-o2;
            return o1Val-o2Val;
        });
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
    }
}
