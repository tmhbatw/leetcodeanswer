package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2316 {

    public long countPairs(int n, int[][] edges) {
        int[] type=new int[n];
        int[] count =new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            type[i]=i;
        }

        for(int[] edge:edges){
            int realType1=getRealType(type,edge[0]);
            int realType2=getRealType(type,edge[1]);

            if(realType2==realType1)
                continue;

            if(count[realType1]<count[realType2]){
                int temp = realType1;
                realType1 = realType2;
                realType2 = temp;
            }

            count[realType1]+=count[realType2];
            type[realType2] = realType1;
        }

        long result = 0;
        for(int i =0;i<n;i++){
            int realType = getRealType(type,i);
            result += (n-count[realType]);
        }

        return result/2;
    }

    private int getRealType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getRealType(type,type[cur]);
    }
}
