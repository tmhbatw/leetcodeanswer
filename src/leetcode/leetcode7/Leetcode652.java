package leetcode.leetcode7;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode652 {

    Map<String,TreeNode> map=new HashMap<>();
    Set<TreeNode> set=new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> result=new ArrayList<>(set);
        return result;
    }

    private String dfs(TreeNode root){
        if(root==null)
            return "";

        String left=dfs(root.left);
        String right=dfs(root.right);
        String cur=root.val+"L"+left+"R"+right;
        if(map.containsKey(cur))
            set.add(map.get(cur));
        else
            map.put(cur,root);

        return cur;
    }

}
