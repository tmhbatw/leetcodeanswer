package leetcode7;

import java.util.HashMap;
import java.util.Map;

public class Leetcode677 {
    /*Description
    *实现一个 MapSum 类，支持两个方法，insert和sum：
    * MapSum() 初始化 MapSum 对象
    * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
    * 如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
    * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
    * */

    class MapSum {

        Map<String,Integer> map;
        /** Initialize your data structure here. */
        public MapSum() {
            map=new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int result=0;
            for(Map.Entry entry:map.entrySet()){
                String key= (String) entry.getKey();
                if(key.indexOf(prefix)==0) {
                    int val = (int) entry.getValue();
                    result += val;
                }
            }
            return result;
        }
    }
}
