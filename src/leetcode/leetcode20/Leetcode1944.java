package leetcode.leetcode20;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1944 {


    //维护一个从大到小的列表
    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];

        List<Integer> list = new ArrayList<>();
        for (int j = heights.length - 1; j >= 0; j--) {
            //前去求当前这个节点的值
            if (list.size() == 0) {
                result[j] = 0;
            } else {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int m = (l + r + 1) / 2;
                    if (list.get(m) >= heights[j]) {
                        l = m;
                    } else {
                        r = m - 1;
                    }
                }
                result[j] = list.size() - l;
            }

            //然后把最后的节点的值挤掉
            while (list.size() > 0 && list.get(list.size() - 1) <= heights[j]) {
                list.remove(list.size() - 1);
            }
            list.add(heights[j]);
        }

        return result;
    }

}
