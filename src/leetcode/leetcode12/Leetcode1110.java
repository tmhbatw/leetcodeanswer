package leetcode.leetcode12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1110 {

    Set<Integer> set=new HashSet<>();
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int num:to_delete)
            set.add(num);
        delNodes(root,true);

        return result;
    }

    public void delNodes(TreeNode root,boolean add){
        if(root==null)
            return;
        if(set.contains(root.val)) {
            delNodes(root.left,true);
            delNodes(root.right,true);
            return ;
        }

        if(add)
            result.add(root);
        if(root.left!=null&&set.contains(root.left.val)){
            delNodes(root.left,true);
            root.left=null;
        }else{
            delNodes(root.left,false);
        }

        if(root.right!=null&&set.contains(root.right.val)){
            delNodes(root.right,true);
            root.right=null;
        }else
            delNodes(root.right,false);
    }

}
