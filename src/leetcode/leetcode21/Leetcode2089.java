package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2089 {


    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> result=new ArrayList<>();

        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid;
        }



        for(int i=l;i<nums.length;i++){
            if(nums[i]!=target)
                break;
            result.add(i);
        }

        return result;
    }

}
