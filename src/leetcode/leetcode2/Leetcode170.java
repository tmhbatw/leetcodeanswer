package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode170 {
    /*Description
    * 设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
    * 实现 TwoSum 类：
    * TwoSum() 使用空数组初始化 TwoSum 对象
    * void add(int number) 向数据结构添加一个数 number
    * boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
    * */

    class TwoSum {
        List<Integer> list;

        /** Initialize your data structure here. */
        public TwoSum() {
            this.list=new ArrayList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            int size=list.size();
            if(size==0||list.get(size-1)<=number){
                list.add(number);
                return;
            }
            if(list.get(0)>=number){
                list.add(0,number);
                return ;
            }
            int left=0,right=size-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(list.get(mid)<number)
                    left=mid+1;
                else if(list.get(mid-1)<number) {
                    list.add(mid, number);
                    return ;
                }else
                    right=mid-1;
            }
            list.add(left,number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            int left=0,right=list.size()-1;
            while(left<right){
                int cur=list.get(left)+list.get(right);
                if(cur<value)
                    left++;
                else if(cur==value)
                    return true;
                else
                    right--;
            }
            return false;
        }
    }
}
