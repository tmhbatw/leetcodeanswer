package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1229 {
    public List<Integer> minAvailableDuration(int[][] slots1,
                                              int[][] slots2,
                                              int duration) {
        Arrays.sort(slots1,(o1,o2)->{return o1[0]-o2[0];});
        Arrays.sort(slots2,(o1,o2)->{return o1[0]-o2[0];});
        int j=0;
        List<Integer> result=new ArrayList<>();
        for (int[] ints : slots1) {
            while (j < slots2.length && slots2[j][1] <= ints[0])
                j++;
            if (j == slots2.length)
                return result;
            if (slots2[j][0] >= ints[1])
                continue;
            while(j<slots2.length&&slots2[j][0]<ints[1]) {
                int min = Math.max(ints[0], slots2[j][0]);
                int max = Math.min(ints[1], slots2[j][1]);
                if (max - min >= duration) {
                    result.add(min);
                    result.add(min + duration);
                    return result;
                }
                j++;
            }
            j--;
        }
        return result;
    }
}
