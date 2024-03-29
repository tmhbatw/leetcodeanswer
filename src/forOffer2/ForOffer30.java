package forOffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer30 {

    class RandomizedSet {

        Map<Integer,Integer> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            int index=map.get(val);
            map.remove(val);
            list.set(index,list.get(list.size()-1));
            if(index!=list.size()-1)
                map.put(list.get(list.size()-1),index);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index=(int)(Math.random()*list.size());
            return list.get(index);
        }
    }
}
