package interview;

public class Problem17_10 {
    /*Description
    * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
    * */
        public int majorityElement(int[] nums) {
            int num=nums[0];
            int count=1;
            for(int i=1;i<nums.length;i++){
                if(count==0){
                    num=nums[i];
                    count=1;
                }else{
                    if(num==nums[i])
                        count++;
                    else
                        count--;
                }
            }
            count=0;
            for(int cur:nums){
                if(cur==num)
                    count++;
            }
            return count>nums.length/2?num:-1;
        }
}
