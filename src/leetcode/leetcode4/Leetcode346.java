package leetcode.leetcode4;

public class Leetcode346 {
    /*Description
    * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
    * */

    class MovingAverage {
        int number=0;
        int index=0;
        int sum=0;
        int capacity;
        int[] num;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            num=new int[size];
            capacity=size;
        }

        public double next(int val) {
            sum-=num[index]-val;
            num[index++]=val;
            if(index==capacity)
                index=0;
            number++;
            return 1.0*sum/Math.min(number,capacity);
        }
    }
}
