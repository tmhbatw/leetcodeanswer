package interview;

import java.util.Arrays;

public class Problem17_19 {
    /*Description
    * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
    * 以任意顺序返回这两个数字均可。
    * */

    public int[] missingTwo(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            while(nums[i]!=i-1&&nums[i]<=length){
                if(nums[nums[i]-1]==nums[i])
                    break;
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        int index=0;
        int[] result=new int[2];
        int max=0;
        for(int i=0;i<length;i++){
            if(nums[i]!=i+1){
                result[index++]=i+1;
            }
            max=Integer.max(max,nums[i]);
        }
        if(index==0)
            return new int[]{length+1,length+2};
        if(index==1){
            result[1]=max==length+1?length+2:length+1;
        }
        return result;
    }
}
