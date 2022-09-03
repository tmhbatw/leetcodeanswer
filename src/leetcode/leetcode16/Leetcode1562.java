package leetcode.leetcode16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1562 {

    public int findLatestStep(int[] arr, int m) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int[] res=new int[n];

        int result = -1;
        for(int i=0;i<arr.length;i++){
            int pre = arr[i]-1>=1?res[arr[i]-1-1]:0;
            int post=arr[i]-1<arr.length-1?res[arr[i]-1+1]:0;

            int cur =pre+post+1;
            if(pre>0){
                res[arr[i]-1-pre]=cur;
                map.put(pre,map.get(pre)-1);
            }
            if(post>0){
                res[arr[i]-1+post]=cur;
                map.put(post,map.get(post)-1);
            }
            res[arr[i]-1]=cur;


            map.put(cur,map.getOrDefault(cur,0)+1);
            // System.out.println(pre+" "+post+" "+map+" "+Arrays.toString(res));

            if(map.getOrDefault(m,0)>0){
                result = i+1;
            }
        }

        return result;
    }

}
