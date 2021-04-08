package leetcode.leetcode3;

import java.util.TreeSet;

public class Leetcode220 {
    /*Description
    * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得nums [i] 和nums [j]
    * 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
    * 如果存在则返回 true，不存在返回 false。
    * */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length<=1)
            return false;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer big=set.ceiling(nums[i]);
            if(big!=null&&(long)big-(long)nums[i]<=t)
                return true;
            Integer small=set.floor(nums[i]);
            if(small!=null&&(long)nums[i]-(long)small<=t)
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(0);
        System.out.println(set.ceiling(1));
    }
}
