package leetcode3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode239 {
    /*Description
    * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
    * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
    * 返回滑动窗口中的最大值。
    * */
    Deque<Integer> deque;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        deque=new ArrayDeque<>();
        for(int i=0;i<k-1;i++){
            addNumber(nums[i]);
        }
        for(int i=k-1;i<nums.length;i++){
            addNumber(nums[i]);
            result[i-k+1]=deque.peekFirst();
            if(nums[i-k+1]==deque.peekFirst())
                deque.pollFirst();
        }
        return result;
    }

    private void addNumber(int cur){
        while(!deque.isEmpty()&&deque.peekLast()<cur)
            deque.pollLast();
        deque.add(cur);
    }

    public static void main(String[] args){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque);
        System.out.println(deque.peekLast());
    }

}
