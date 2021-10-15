package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<mat.length;i++)
            res.add(new int[]{i, Arrays.stream(mat[i]).sum()});
        res.sort((o1,o2)->{
            if(o1[1]==o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=res.get(i)[0];
        }
        return result;
    }
}
