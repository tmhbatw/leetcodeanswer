package leetcode.leetcode17;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1696 {

    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        dq.addFirst(nums[0]);
        int[] res=new int[nums.length];
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            res[i] = dq.getFirst()+nums[i];
            while(!dq.isEmpty()&&dq.peekLast()<res[i]){
                dq.pollLast();
            }
            dq.addLast(res[i]);

            if(i>=k){
                if(dq.peekFirst()==res[i-k]){
                    dq.pollFirst();
                }
            }
        }

        return res[nums.length-1];
    }

}
