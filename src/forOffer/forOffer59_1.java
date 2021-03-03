package forOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class forOffer59_1 {
    /*Description
    * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0)
            return new int[]{};
        int[] res=new int[nums.length-k+1];
        Deque<Integer> dp=new ArrayDeque<>();
        for(int i=0;i<k-1;i++){
            add(dp,nums[i]);
        }
        for(int i=k-1;i<nums.length;i++){
            add(dp,nums[i]);
            res[i-k+1]=dp.peekFirst();
            int val=nums[i-k+1];
            if(dp.peekFirst()==val)
                dp.pollFirst();
        }
        return res;
    }

    private void add(Deque<Integer> dp,int cur){
        while(!dp.isEmpty()&&dp.peekLast()<cur){
            dp.pollLast();
        }
        dp.add(cur);
    }

    public static void main(String[] args){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.peekLast());
    }
}
