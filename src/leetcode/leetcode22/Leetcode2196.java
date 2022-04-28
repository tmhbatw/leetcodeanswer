package leetcode.leetcode22;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode2196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int[] description:descriptions){
            map.putIfAbsent(description[0],new TreeNode(description[0]));
            map.putIfAbsent(description[1],new TreeNode(description[1]));

            if(description[2]==1)
                map.get(description[0]).left=map.get(description[1]);
            else
                map.get(description[0]).right=map.get(description[1]);

            set.add(description[1]);
        }

        for(int key:map.keySet()){
            if(!set.contains(key)){
                return map.get(key);
            }
        }

        return null;
    }
}
