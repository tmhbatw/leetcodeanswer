package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o2[0]-o1[0];
        });
        List<int[]> result=new ArrayList<>();
        for(int[] cur:people){
            result.add(cur[1],cur);
        }
        for(int i=0;i<people.length;i++)
            people[i]=result.get(i);

        return people;
    }
}
