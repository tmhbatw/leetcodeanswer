package leetcode.leetcode26;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums2[j][0] < nums1[i][0]) {
                result.add(nums2[j++]);
            }
            if (j < nums2.length && nums2[j][0] == nums1[i][0]) {
                nums1[i][1] += nums2[j++][1];
            }
            result.add(nums1[i]);
        }
        while (j < nums2.length) {
            result.add(nums2[j++]);
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++)
            res[i] = result.get(i);
        return res;
    }

}
