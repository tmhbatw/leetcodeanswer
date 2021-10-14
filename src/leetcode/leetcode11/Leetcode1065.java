package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1065 {

    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result=new ArrayList<>();
        for(String cur:words){
            int start=-1;
            while((start=text.indexOf(cur,start+1))!=-1){
                result.add(new int[]{start,start+cur.length()-1});
            }
        }
        result.sort((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int[][] res=new int[result.size()][2];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
    }
}
