package leetcode.leetcode29;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode2848 {

    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : nums) {
            for (int i = list.get(0); i <= list.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }

}
