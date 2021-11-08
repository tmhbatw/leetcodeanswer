package leetcode.leetcode6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode508 {

    Map<Integer,Integer> map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                result=new ArrayList<>();
            }
            if(map.get(key)==max)
                result.add(key);
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int cur=root.val+dfs(root.left)+dfs(root.right);
        map.putIfAbsent(cur,0);
        map.put(cur,map.get(cur)+1);
        return cur;
    }
}
