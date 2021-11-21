package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1567 {

    public int getMaxLen(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                list.add(i);
        }
        list.add(nums.length);

        int result=0;

        for(int i=1;i<list.size();i++){
            result=Math.max(result,getRes(nums,list.get(i-1)+1,list.get(i)-1));
        }
        return result;
    }

    private int getRes(int[] nums,int i, int j){
        if(j<i)
            return 0;

        int count=0;
        int first=-1;
        int last=0;
        for(int index=i;index<=j;index++){
            if(nums[index]<0){
                count++;
                last=index;
                if(first==-1)
                    first=index;
            }
        }
        if(count%2==0)
            return j-i+1;
        return Math.max(j-first,last-i);
    }
}
