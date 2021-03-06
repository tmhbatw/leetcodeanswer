package interview;

import java.util.Arrays;

public class Problem17_4 {
    /*Description
    *数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。
    * 你有办法在O(n)时间内完成吗？
    * */

    public int missingNumber(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            while(i!=nums[i]){
                if(nums[i]==length)
                    break;
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            if(nums[i]!=i)
                return i;
        }
        return -1;
    }
}
