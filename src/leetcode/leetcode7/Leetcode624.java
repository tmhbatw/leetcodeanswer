package leetcode.leetcode7;

import java.util.List;

public class Leetcode624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);

        int result=0;
        for(int i=1;i<arrays.size();i++){
            List<Integer> list=arrays.get(i);
            result=Math.max(Math.max(max-list.get(0),list.get(list.size()-1)-min),result);
            min=Math.min(min,list.get(0));
            max=Math.max(max,list.get(list.size()-1));
        }

        return result;
    }
}
