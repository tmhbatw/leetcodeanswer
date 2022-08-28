package leetcode.leetcode6;

import java.util.HashMap;
import java.util.Map;

public class Leetcode519 {

    class Solution {

        int reset;
        int total;
        int m;
        Map<Integer,Integer> map;
        public Solution(int m, int n) {
            this.m=n;
            this.reset=m*n;
            this.total=reset;
            this.map=new HashMap<>();
        }

        public int[] flip() {
            int r= (int) (Math.random()*total);
            //System.out.println(r);
            total--;
            int cur =map.getOrDefault(r,r);
            map.put(r,map.getOrDefault(total,total));
            return new int[]{cur/m,cur%m};
        }

        public void reset() {
            this.total=reset;
            this.map=new HashMap<>();
        }
    }

}
