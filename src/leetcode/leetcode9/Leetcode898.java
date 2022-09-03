package leetcode.leetcode9;

import java.util.HashSet;
import java.util.Set;

public class Leetcode898 {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int num : arr) {
            Set<Integer> newCur = new HashSet<>();
            newCur.add(num);
            for (int pre : cur)
                newCur.add(pre | num);

            cur = newCur;
            result.addAll(newCur);
        }

        return result.size();
    }


}
