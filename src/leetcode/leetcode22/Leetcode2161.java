package leetcode.leetcode22;

public class Leetcode2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int length=nums.length;
        int[] result=new int[length];

        int left=0;
        for (int num : nums) {
            if (num < pivot)
                result[left++] = num;
        }

        int right=nums.length-1;
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]>pivot)
                result[right--]=nums[j];
        }

        for(int i=left;i<=right;i++){
            result[i]=pivot;
        }

        return result;
    }
}
