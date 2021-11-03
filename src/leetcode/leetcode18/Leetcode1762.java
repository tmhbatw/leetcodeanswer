package leetcode.leetcode18;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> list=new ArrayList<>();
        int max=0;
        for(int j=heights.length-1;j>=0;j--){
            if(heights[j]>max){
                list.add(j);
                max=heights[j];
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(list.size()-1-i);
        return res;
    }
}
