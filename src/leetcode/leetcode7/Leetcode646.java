package leetcode.leetcode7;

import java.util.Arrays;
import java.util.TreeMap;

public class Leetcode646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });


        int[] res=new int[pairs.length];
        res[0]=1;

        for(int i=1;i<res.length;i++){
            int cur=0;
            for(int j=i-1;j>=0;j--){
                if(pairs[i][0]>pairs[j][1])
                    cur=Math.max(cur,res[j]);
            }
            res[i]=cur+1;
        }

        return res[pairs.length-1];
    }
}
