package leetcode.leetcode9;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode872 {

    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        addNodeVal(root1,list1);
        addNodeVal(root2,list2);
        return isSame(list1,list2);
    }

    private boolean isSame(List<Integer> l1,List<Integer> l2){
        if(l1.size()!=l2.size())
            return false;
        for(int i=0;i<l1.size();i++){
            if(!l1.get(i).equals(l2.get(i)))
                return false;
        }
        return true;
    }

    private void addNodeVal(TreeNode cur,List<Integer> list){
        if(cur==null)
            return;
        if(cur.left==null&&cur.right==null) {
            list.add(cur.val);
            return;
        }
        addNodeVal(cur.left,list);
        addNodeVal(cur.right,list);
    }
}
