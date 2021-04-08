package leetcode.leetcode4;

import java.util.*;

public class Leetcode381 {
    /*Description
    *设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
    * 注意: 允许出现重复元素。
    * insert(val)：向集合中插入元素 val。
    * remove(val)：当 val 存在时，从集合中移除一个 val。
    * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
    * */
    class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        int number=0;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map=new HashMap<>();
            list=new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean result=false;
            if(!map.containsKey(val)){
                map.put(val,new HashSet<>());
            }
            Set<Integer> set=map.get(val);
            if(set.size()==0)
                result=true;
            set.add(number++);
            list.add(val);
            return result;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            Set<Integer> set=map.getOrDefault(val,new HashSet<>());
            if(set.size()==0)
                return false;
            int removeIndex=set.iterator().next();
            set.remove(removeIndex);
            if(removeIndex!=number-1){
                int newVal=list.get(number-1);
                list.set(removeIndex,newVal);
                Set<Integer> curSet=map.get(newVal);
                curSet.remove(number-1);
                curSet.add(removeIndex);
            }

            list.remove(--number);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get((int)(Math.random()*number));
        }
    }
}
