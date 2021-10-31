package leetcode.leetcode14;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        getList(l1,root1);
        List<Integer> l2=new ArrayList<>();
        getList(l2,root2);
        l1.add(Integer.MAX_VALUE);
        l2.add(Integer.MAX_VALUE);
        List<Integer> result=new ArrayList<>();
        int i1=0,i2=0;
        for(int i=0;i<l1.size()+l2.size()-2;i++){
            if(l1.get(i1)<l2.get(i2))
                result.add(l1.get(i1++));
            else
                result.add(l2.get(i2++));
        }
        return result;
    }

    private void getList(List<Integer> list,TreeNode root){
        if(root==null)
            return;
        getList(list,root.left);
        list.add(root.val);
        getList(list,root.right);
    }
}
