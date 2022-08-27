package leetcode.leetcode24;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode2385 {

    Map<Integer, List<Integer>> map=new HashMap<>();
    Set<Integer> reached=new HashSet<>();
    public int amountOfTime(TreeNode root, int start) {
        dfs(root,null);
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        reached.add(start);

        int result=-1;
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            while(size-->0){
                int cur =q.poll();
                for(int n:map.get(cur)){
                    if(!reached.contains(n)){
                        reached.add(n);
                        q.add(n);
                    }
                }
            }
        }
        return result;
    }

    private void dfs(TreeNode root,Integer father){
        List<Integer> l=new ArrayList<>();
        if(father!=null)
            l.add(father);
        if(root.left!=null){
            dfs(root.left,root.val);
            l.add(root.left.val);
        }
        if(root.right!=null){
            dfs(root.right,root.val);
            l.add(root.right.val);
        }
        map.put(root.val,l);
    }

}
