package leetcode.leetcode3;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode236 {
    /*Description
    * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
    * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    * */

    Map<TreeNode,TreeNode> map;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map=new HashMap<>();
        addMap(root);
        Set<TreeNode> set=new HashSet<>();
        set.add(p);
        while(map.containsKey(p)){
            p=map.get(p);
            set.add(p);
        }
        while(!set.contains(q)){
            q=map.get(q);
        }
        return q;
    }

    private void addMap(TreeNode root){
        if(root.left!=null){
            map.put(root.left,root);
            addMap(root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            addMap(root.right);
        }
    }
}
