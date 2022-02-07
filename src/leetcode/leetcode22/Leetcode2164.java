package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode2164 {

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            nums[i*2]=list.get(i);
        }

        list=new ArrayList<>();
        for(int i=1;i<nums.length;i+=2){
            list.add(nums[i]);
        }
        list.sort(Collections.reverseOrder());
        for(int i=1;i<nums.length;i+=2)
            nums[i]=list.get(i/2);

        return nums;
    }
}
