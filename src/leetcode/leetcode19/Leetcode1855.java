package leetcode.leetcode19;

public class Leetcode1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int j=0;
        int result=0;
        for(int i=0;i<nums1.length;i++){
            while(j<nums2.length-1&&nums2[j+1]>=nums1[i])
                j++;
            result=Math.max(j-i,result);
        }
        return result;
    }
}
