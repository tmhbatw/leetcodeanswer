package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2221 {

    public int triangularSum(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums)
            list.add(num);


        while(list.size()>1){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<list.size()-1;i++){
                l.add((list.get(i)+list.get(i+1))%10);
            }
            list=l;
        }

        return list.get(0);
    }
}
