package leetcode.leetcode1;

public class Leetcode34 {
    /*Description
    * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    * 如果数组中不存在目标值 target，返回[-1, -1]。
    * 进阶：
    * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
    * */

    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[]{-1,-1};
        int length=nums.length;
        if(nums[0]>target||nums[length-1]<target)
            return new int[]{-1,-1};
        int[] result=new int[]{-1,-1};
        int left=0,right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(mid==0||nums[mid-1]<target){
                if(nums[mid]!=target)
                    return result;
                result[0]=mid;
                break;
            }else
                right=mid-1;
        }
        left=0;right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            System.out.println(mid+" "+nums[mid]);
            if(nums[mid]>target){
                right=mid-1;
            }else if(mid==length-1||nums[mid+1]>target){
                result[1]=mid;
                return result;
            }else
                left=mid+1;
        }
        return result;
    }
}
