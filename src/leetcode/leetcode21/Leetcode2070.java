package leetcode.leetcode21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Leetcode2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));

        int max=0;
        for(int[] item:items){
            max=Math.max(item[1],max);
            item[1]=max;
        }

        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            //要求items[mid]<=queries[i]&&items[mid+1]>queries[i];
            if(items[0][0]>queries[i]){
                result[i]=0;
                continue;
            }
            int l=0,r=items.length-1;
            while(l<r){
                int mid=(l+r+1)/2;

                if(items[mid][0]>queries[i]){
                    r=mid-1;
                }else{
                    l=mid;
                }
            }
            result[i]=items[l][1];
        }

        return result;
    }


}
