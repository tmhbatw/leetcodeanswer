package leetcode.leetcode3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode295 {
    /*Description
    *中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
    * 例如，
    * [2,3,4]的中位数是 3
    * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
    * 设计一个支持以下两种操作的数据结构：
    * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    * double findMedian() - 返回目前所有元素的中位数
    * */

    class MedianFinder {

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        /** initialize your data structure here. */
        public MedianFinder() {
            min=new PriorityQueue<>(Comparator.reverseOrder());
            max=new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(!max.isEmpty()&&num>max.peek()){
                if(min.size()==max.size())
                    min.add(max.poll());
                max.add(num);
            }
            else {
                min.add(num);
                if (min.size() - max.size() == 2)
                    max.add(min.poll());
            }
        }

        public double findMedian() {
            if(min.isEmpty())
                return 0;
            if(min.size()==max.size())
                return (min.peek()+ max.peek())*1.0/2;
            return min.peek();
        }
    }
}
