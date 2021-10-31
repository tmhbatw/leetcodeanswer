package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1409 {

    public int[] processQueries(int[] queries, int m) {
        int[] result=new int[queries.length];
        List<Integer> list=new ArrayList<>();
        for(int j=m;j>=1;j--)
            list.add(j);

        int index=0;
        for(int cur:queries){
            for(int j=m-1;j>=0;j--){
                if(list.get(j)==cur){
                    result[index++]=m-j;
                    list.remove(j);
                    list.add(cur);
                }
            }
        }
        return result;
    }
}
