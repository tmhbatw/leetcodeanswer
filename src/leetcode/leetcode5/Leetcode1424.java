package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size=0;
        int sum=0;
        for(int i=0;i<nums.size();i++){
            size=Math.max(size,i+nums.get(i).size());
            sum+=nums.get(i).size();
        }

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<size;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                list.get(i+j).add(nums.get(i).get(j));
            }
        }
        int[] result=new int[sum];
        int index=0;

        for (List<Integer> integers : list) {
            for (int j = integers.size() - 1; j >= 0; j--) {
                result[index++] = integers.get(j);
            }
        }

        return result;
    }

}
