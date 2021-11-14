package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode981 {

    class TimeMap {
        Map<String, TreeMap<Integer,String>> map=new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key,new TreeMap<>());
            map.get(key).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key))
                return "";
            TreeMap<Integer,String> curMap=map.get(key);
            if(curMap.floorKey(timestamp)==null)
                return "";
            return curMap.get(curMap.floorKey(timestamp));
        }
    }
}
