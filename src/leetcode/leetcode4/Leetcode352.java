package leetcode.leetcode4;

import java.util.TreeMap;

public class Leetcode352 {

    class SummaryRanges {

        TreeMap<Integer,Integer> map;
        public SummaryRanges() {
            this.map=new TreeMap<>();
        }

        public void addNum(int val) {
            Integer pre=map.floorKey(val);
            if(pre!=null&&map.get(pre)>=val)
                return;
            if(pre==null||map.get(pre)<val-1){
                Integer post=map.ceilingKey(val);
                if(post!=null&&post==val+1){
                    map.put(val,map.get(post));
                    map.remove(post);
                }else
                    map.put(val,val);
            }
            else{
                map.put(pre,map.get(pre)+1);
                Integer post=map.ceilingKey(val+1);
                if(post!=null&&post==val+1){
                    map.put(pre,map.get(post));
                    map.remove(post);
                }
            }
        }

        public int[][] getIntervals() {
            int[][] res=new int[map.size()][2];
            int index=0;
            for(int key:map.keySet()){
                res[index++]=new int[]{key,map.get(key)};
            }
            return res;
        }
    }

}
