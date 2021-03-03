package forOffer;

import java.util.Collections;
import java.util.PriorityQueue;

public class forOffer41 {
    /*Description
    * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    * 例如，
    * [2,3,4]的中位数是 3
    * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
    * 设计一个支持以下两种操作的数据结构：
    * void addNum(int num) - 从数据流中添加一个整数到数据结构中
    * double findMedian() - 返回目前所有元素的中位数。
    * */

    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        /** initialize your data structure here. */
        public MedianFinder() {
            max=new PriorityQueue<>();
            min=new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if(min.isEmpty())
                min.add(num);
            else if(min.size()>max.size()){
                min.add(num);
                max.add(min.poll());
            }
            else{
                if(num>max.peek()){
                    min.add(max.poll());
                    max.add(num);
                }else{
                    min.add(num);
                }
            }
        }

        public double findMedian() {
            if(min.size()>max.size())
                return min.peek();
            return 1.0*(min.peek()+max.peek())/2;
        }
    }

}
