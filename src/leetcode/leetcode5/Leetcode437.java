package leetcode.leetcode5;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        Stack<TreeNode> s1=new Stack<>();
        Stack<List<Integer>> s2=new Stack<List<Integer>>();

        s1.add(root);
        List<Integer> list=new ArrayList<>();
        list.add(0);
        s2.add(list);

        int result=0;
        while(!s1.isEmpty()){
            TreeNode node=s1.pop();
            List<Integer> cur=s2.pop();
            List<Integer> list2=new ArrayList<>();
            list2.add(0);
            for(int val:cur){
                list2.add(val+node.val);
                if(val+node.val==targetSum)
                    result++;
            }
            if(node.left!=null){
                s1.add(node.left);
                s2.add(list2);
            }
            if(node.right!=null){
                s1.add(node.right);
                s2.add(list2);
            }
        }

        return result;
    }

}
