package leetcode4;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode366 {
    /*Description
    *给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
    * 依次从左到右，每次收集并删除所有的叶子节点
    * 重复如上过程直到整棵树为空
    * */

    Map<TreeNode,TreeNode> leftMap;
    Map<TreeNode,TreeNode> rightMap;
    List<List<Integer>> result;
    Queue<TreeNode> queue;
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null)
            return Collections.EMPTY_LIST;
        leftMap=new HashMap<>();
        rightMap=new HashMap<>();
        result=new ArrayList<>();
        queue=new LinkedList<>();
        findListNodeFather(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                res.add(cur.val);
                if(leftMap.containsKey(cur)){
                    TreeNode father=leftMap.get(cur);
                    if(father.right==null)
                        queue.add(father);
                    else
                        father.left=null;
                }
                if(rightMap.containsKey(cur)){
                    TreeNode father=rightMap.get(cur);
                    if(father.left==null)
                        queue.add(father);
                    else
                        father.right=null;
                }
            }
            result.add(res);
        }
        return result;
    }

    private void findListNodeFather(TreeNode root){
        if(root.left!=null){
            leftMap.put(root.left,root);
            findListNodeFather(root.left);
        }
        if(root.right!=null){
            rightMap.put(root.right,root);
            findListNodeFather(root.right);
        }
        if(root.left==null&&root.right==null){
            queue.add(root);
        }
    }
}
