package leetcode.leetcode20;

import datastructure.TreeNode;

import java.util.TreeMap;

public class Leetcode1902 {

    public int maxDepthBST(int[] order) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);
        map.put(Integer.MAX_VALUE,0);

        int result=0;
        for(int cur:order){
            int lowerLevel=map.floorEntry(cur).getValue();
            int upperLevel=map.ceilingEntry(cur).getValue();
            int height=Math.max(lowerLevel,upperLevel)+1;

            map.put(cur,height);
            result=Math.max(result,height);
        }

        return result;
    }
}
