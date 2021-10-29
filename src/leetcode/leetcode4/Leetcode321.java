package leetcode.leetcode4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leetcode321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result=new int[k];
        for(int i=Math.max(0,k-nums2.length);i<=Math.min(nums1.length,k);i++){
            int[] dq1=getDq(nums1,i);
            int[] dq2=getDq(nums2,k-i);
            int[] curRes=getNum(dq1,dq2);
            if(isBig(result,curRes))
                result=curRes;
        }
        return result;
    }

    private boolean isBig(int[] num1,int[] num2){
        for(int i=0;i<num1.length;i++){
            if(num1[i]<num2[i])
                return true;
            if(num1[i]>num2[i])
                return false;
        }
        return false;
    }

    private int[] getNum(int[] dq1,int[] dq2){
        int[] res=new int[dq1.length+dq2.length];
        int index1=0,index2=0;
        for(int i=0;i<res.length;i++){
            if(compare(dq1,index1,dq2,index2)>=0)
                res[i]=dq1[index1++];
            else
                res[i]=dq2[index2++];
        }
        return res;
    }

    private int compare(int[] dp1,int index1,int[] dp2,int index2){
        while(index1<dp1.length&&index2<dp2.length){
            int diff=dp1[index1]-dp2[index2];
            if(diff!=0)
                return diff;
            index1++;
            index2++;
        }
        return (dp1.length-index1)-(dp2.length-index2);
    }

    private int[] getDq(int[] nums,int k){
        Deque<Integer> dq=new ArrayDeque<>();
        int leave=nums.length-k;
        for(int cur:nums){
            while(!dq.isEmpty()&&dq.peekLast()<cur&&leave>0) {
                dq.pollLast();
                leave--;
            }
            dq.addLast(cur);
        }
        while(leave>0) {
            dq.pollLast();
            leave--;
        }
        int[] res=new int[dq.size()];
        for(int i=0;i<res.length;i++)
            res[i]=dq.pollFirst();
        return res;
    }
}
