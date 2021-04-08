package leetcode.leetcode4;

import java.util.*;

public class Leetcode380 {
    /*Description
    * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构。
    * insert(val)：当元素 val 不存在时，向集合中插入该项。
    * remove(val)：元素 val 存在时，从集合中移除该项。
    * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
    * */

    class RandomizedSet {
        Map<Integer,Integer> map;
        List<Integer> list;
        int number;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
            number=0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!map.containsKey(val)){
                map.put(val,number++);
                list.add(val);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            int removeIndex=map.get(val);
            if(number!=removeIndex){
                int newVal=list.get(number-1);
                map.put(newVal,removeIndex);
                list.set(removeIndex,newVal);
            }
            map.remove(val);
            list.remove(number-1);
            number--;
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get((int)(Math.random()*number));
        }
    }

    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(1,3);
        System.out.println((list));
    }
}
