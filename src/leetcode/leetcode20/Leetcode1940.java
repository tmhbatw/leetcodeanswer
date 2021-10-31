package leetcode.leetcode20;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1940 {

    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result=new ArrayList<>();
        if(arrays.length==0)
            return result;
        for(int i=0;i<arrays[0].length;i++){
            result.add(arrays[0][i]);
        }

        for(int i=1;i<arrays.length;i++){
            int index=0;
            List<Integer> cur=new ArrayList<>();
            for(int j=0;j<arrays[i].length;j++){
                while(index<result.size()&&result.get(index)<arrays[i][j])
                    index++;
                if(index==result.size())
                    break;
                if(result.get(index)==arrays[i][j])
                    cur.add(result.get(index++));
            }
            result=cur;
        }
        return result;
    }
}
