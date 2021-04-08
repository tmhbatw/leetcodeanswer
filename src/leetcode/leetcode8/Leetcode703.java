package leetcode.leetcode8;

import java.util.PriorityQueue;

public class Leetcode703 {
    /*Description
    * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
    * 请实现 KthLargest类：
    * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
    * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素.
    * */

    class KthLargest {
        PriorityQueue<Integer> p=new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k=k;
            for(int cur:nums)
                add(cur);
        }

        public int add(int val) {
            p.add(val);
            if(p.size()>k)
                p.poll();
            return p.peek();
        }
    }
}
