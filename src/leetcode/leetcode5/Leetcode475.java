package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        List<Integer> list=new ArrayList<>();
        list.add(-1000000000);
        for(int cur:heaters)
            list.add(cur);
        list.add(2000000000);

        int index1=0;
        int index2=1;

        int result=0;
        for(int cur:houses){
            while(cur>list.get(index2)) {
                index1++;
                index2++;
            }
            result=Math.max(result,Math.min(cur-list.get(index1),
                    list.get(index2)-cur));

        }
        return result;
    }
}
