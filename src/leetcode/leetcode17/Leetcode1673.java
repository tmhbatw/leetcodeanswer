package leetcode.leetcode17;

import java.util.Stack;

public class Leetcode1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s=new Stack<>();
        int kk=nums.length-k;

        for(int num:nums){
            while(!s.isEmpty()&&s.peek()>num&&kk>0){
                kk--;
                s.pop();
            }
            s.add(num);
        }

        int[] res=new int[k];
        int index=0;
        for(int cur:s){
            res[index++]=cur;
            if(index==k)
                break;
        }
        return res;
    }
}
