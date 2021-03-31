package interview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Problem17_20 {
    /*Description
    * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
    * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
    * 例如，[2,3,4]的中位数是 3
    * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
    * 设计一个支持以下两种操作的数据结构：
    * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    * double findMedian() - 返回目前所有元素的中位数。
    * */

    class MedianFinder {
        PriorityQueue<Integer> maxStack;
        PriorityQueue<Integer> minStack;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxStack=new PriorityQueue<>();
            minStack=new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            minStack.add(num);
            if(minStack.size()-maxStack.size()==2)
                maxStack.add(minStack.poll());
            else{
                if(!maxStack.isEmpty()&&minStack.peek()>maxStack.peek()){
                    int max=maxStack.poll();
                    int min=minStack.poll();
                    maxStack.add(min);
                    minStack.add(max);
                }
            }
        }

        public double findMedian() {
            if(maxStack.size()==minStack.size()){
                return (minStack.peek()*1.0+maxStack.peek()*1.0)/2;
            }else{
                return minStack.peek();
            }
        }
    }
}
