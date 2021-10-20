package forOffer2;

import java.util.TreeMap;

public class ForOffer71 {
    class Solution {

        int rand=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        public Solution(int[] w) {
            for(int i=0;i<w.length;i++){
                rand+=w[i];
                map.put(rand,i);
            }
        }

        public int pickIndex() {
            int index=(int)Math.random()*rand;
            return map.get(map.ceilingKey(index+1));
        }
    }

}
