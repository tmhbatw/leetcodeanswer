package leetcode.leetcode21;

import java.util.HashMap;
import java.util.TreeMap;

public class Leetcode2034 {

    class StockPrice {

        TreeMap<Integer,Integer> time;
        TreeMap<Integer,Integer> val;
        public StockPrice() {
            this.time= new TreeMap<>();
            this.val = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if(time.containsKey(timestamp)){
                int val=time.get(timestamp);
                if(this.val.get(val)==1)
                    this.val.remove(val);
                else
                    this.val.put(val,this.val.get(val)-1);
            }

            time.put(timestamp,price);
            this.val.put(price,this.val.getOrDefault(price,0)+1);
        }

        public int current() {
            return time.get(time.lastKey());
        }

        public int maximum() {
            return val.lastKey();
        }

        public int minimum() {
            return val.firstKey();
        }
    }
}
