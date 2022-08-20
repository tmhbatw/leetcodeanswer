package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int sum1= Arrays.stream(nums1).sum();
        int sum2=Arrays.stream(nums2).sum();

        return sum1>sum2?getRes(nums1,nums2,sum1-sum2):
                getRes(nums2,nums1,sum2-sum1);
    }


    private int getRes(int[] nums1,int[] nums2,int diff){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j=nums1.length-1,i=0;

        int result=0;
        while(diff>0){
            int change1=j>=0?nums1[j]-1:0;
            int change2=i<nums2.length?6-nums2[i]:0;
            if(change1==0&&change2==0)
                return -1;
            if(change1>change2){
                diff-=change1;
                j--;
            }else{
                diff-=change2;
                i++;
            }
            result++;
        }
        return result;
    }

}
