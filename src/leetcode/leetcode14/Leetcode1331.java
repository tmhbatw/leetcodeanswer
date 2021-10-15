package leetcode.leetcode14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] res=arr.clone();
        Arrays.sort(res);
        int index=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<res.length;i++){
            if(map.containsKey(res[i]))
                continue;
            map.put(res[i],index++);
        }
        System.out.println(map);

        for(int i=0;i<arr.length;i++)
            res[i]=map.get(arr[i]);
        return res;
    }
}
