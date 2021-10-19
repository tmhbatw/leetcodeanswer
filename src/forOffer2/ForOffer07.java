package forOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForOffer07 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            int target=-nums[i];
            while(l<r){
                if(nums[l]+nums[r]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while(l<nums.length-1&&nums[l+1]==nums[l])
                        l++;
                    while(r>=1&&nums[r]==nums[r-1])
                        r--;
                    l++;
                    r--;
                }else if(nums[l]+nums[r]<target) {
                    while(l<nums.length-1&&nums[l+1]==nums[l])
                        l++;
                    l++;
                }
                else {
                    while(r>=1&&nums[r]==nums[r-1])
                        r--;
                    r--;
                }
            }
            while(i<nums.length-1&&nums[i+1]==nums[i])
                i++;
        }
        return result;
    }
}
